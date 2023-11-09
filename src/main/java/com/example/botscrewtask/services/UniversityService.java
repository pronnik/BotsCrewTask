package com.example.botscrewtask.services;

import com.example.botscrewtask.dao.DepartmentDAO;
import com.example.botscrewtask.dao.EmploymentDAO;
import com.example.botscrewtask.dao.LectorDAO;
import com.example.botscrewtask.entities.DepartmentEntity;
import com.example.botscrewtask.entities.EmploymentEntity;
import com.example.botscrewtask.entities.LectorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final LectorDAO lectorDao;
    private final DepartmentDAO departmentDAO;
    private final EmploymentDAO employmentDAO;


    public double averageSalaryByDepartmentName(String departmentName) {
        List<EmploymentEntity> employers = employmentDAO.findEmployeeByDepartment(departmentName);
        return employers.stream()
                .map(EmploymentEntity::getSalary)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public int departmentSize(String departmentName) {
        List<EmploymentEntity> employers = employmentDAO.findEmployeeByDepartment(departmentName);

        return employers.size();
    }

    public String departmentHead(String departmentName) {
        DepartmentEntity department = departmentDAO.getDepartment(departmentName);
        LectorEntity lector = lectorDao.lectorByID(department.getDepartmentHeadId());

        return lector.getLectorName();
    }

    public Statistic departmentStatistic(String departmentName) {
        List<EmploymentEntity> employers = employmentDAO.findEmployeeByDepartment(departmentName);
        int assistant = 0, associateProfessor = 0, professor = 0;

        for (EmploymentEntity employee : employers) {
            switch (employee.getLector().getLectorDegree()) {
                case 0 -> assistant++;
                case 1 -> associateProfessor++;
                case 2 -> professor++;
            }
        }

        return new Statistic(assistant, associateProfessor, professor);
    }

    public String searchByTemplate(String template) {
        List<LectorEntity> lectors = lectorDao.lectorsByTemplate(template);

        return lectors.stream()
                .map(LectorEntity::getLectorName)
                .collect(Collectors.joining(","));
    }

    public record Statistic(int assistant, int associateProfessor, int professor) {
    }
}
