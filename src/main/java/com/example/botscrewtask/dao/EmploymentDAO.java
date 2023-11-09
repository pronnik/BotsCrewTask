package com.example.botscrewtask.dao;

import com.example.botscrewtask.entities.DepartmentEntity;
import com.example.botscrewtask.entities.EmploymentEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class EmploymentDAO {
    private final SessionFactory sessionFactory;
    private final DepartmentDAO departmentDAO;

    @Transactional
    public List<EmploymentEntity> findEmployeeByDepartment(String departmentName) {
        Session session = sessionFactory.openSession();
        DepartmentEntity department = departmentDAO.getDepartment(departmentName);
        Transaction transaction = session.beginTransaction();
        List<EmploymentEntity> employers = session.createQuery("from EmploymentEntity where departmentId =" + department.getDepartmentId(), EmploymentEntity.class).getResultList();
        transaction.commit();
        session.close();
        return employers;
    }


}
