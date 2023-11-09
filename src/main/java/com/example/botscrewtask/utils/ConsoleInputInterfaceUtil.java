package com.example.botscrewtask.utils;

import com.example.botscrewtask.services.UniversityService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static com.example.botscrewtask.services.UniversityService.Statistic;

@Service
@RequiredArgsConstructor
public class ConsoleInputInterfaceUtil {

    private final UniversityService universityService;

    @PostConstruct
    public void launch() {
        while (true) {
            request();
        }
    }

    public void request() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String request = scanner.nextLine();
            if (request.contains("Who is head of department ")) {
                String departmentName = request.replaceAll("Who is head of department ", "");
                System.out.println("Head of " + departmentName + " department is " + universityService.departmentHead(departmentName));

            } else if (request.contains("Show the average salary for the department ")) {
                String departmentName = request.replaceAll("Show the average salary for the department ", "");
                System.out.println("The average salary of " + departmentName + " is " + universityService.averageSalaryByDepartmentName(departmentName));

            } else if (request.contains("Show count of employee for ")) {
                String departmentName = request.replaceAll("Show count of employee for ", "");
                System.out.println(universityService.departmentSize(departmentName));

            } else if (request.contains("Global search by ")) {
                String template = request.replaceAll("Global search by ", "");
                System.out.println("asd" + universityService.searchByTemplate(template));


            } else if (request.contains(" statistics")) {
                String departmentName = request.replaceAll("Show ", "").replaceAll(" statistics", "");
                Statistic statistic = universityService.departmentStatistic(departmentName);
                System.out.println("assistans - " + statistic.assistant() + ". \n" +
                        "associate professors - " + statistic.associateProfessor() + "\n" +
                        "professors - " + statistic.professor() + "\n");

            }
        }
    }
}
