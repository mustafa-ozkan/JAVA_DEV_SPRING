package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DerivedqueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions() {
        System.out.println("--------Regions start--------------");

        System.out.println("find by country: " + regionRepository.findByCountry("Canada"));

        System.out.println("find distinct by country: " + regionRepository.findDistinctByCountry("Canada"));

        System.out.println("find country names containing by country: " + regionRepository.findAllByCountryContaining("United"));

        System.out.println("find country names containing by country order by region: " + regionRepository.findAllByCountryContainingOrderByRegion("United"));

        System.out.println("find top 2 by country: " + regionRepository.findTop2ByCountry("United States"));


        System.out.println("--------Regions ends--------------");
    }

    @PostConstruct
    public void testDepartments() {

        System.out.println("--------Departments start--------------");

        System.out.println("findByDivision: " + departmentRepository.findByDivision("Health"));

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Health"));

        System.out.println("findByDivisionEquals: " + departmentRepository.findByDivisionEquals("Health"));

        System.out.println("findByDivisionEndsWith: " + departmentRepository.findByDivisionEndsWith("ics"));

        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));


        System.out.println("--------Departments ends--------------");

    }


    @PostConstruct
    public void testEmployees() {
        System.out.println("--------Employees start--------------");

        System.out.println("findByEmail: " + employeeRepository.findByEmail("..."));
//
//        System.out.println("findByFirstNameAndLastNameOrEmail: " + employeeRepository.findByFirstNameAndLastNameOrEmail("..", "", ""));
//
//        System.out.println("findByFirstNameNot: " + employeeRepository.findByFirstNameNot("Mike"));
//
//        System.out.println("findByLastNameStartsWith: " + employeeRepository.findByLastNameStartsWith("Mi"));
//
//        System.out.println("findBySalaryGreaterThan: " + employeeRepository.findBySalaryGreaterThan(100000));
//
//        System.out.println("findBySalaryGreaterThanEqualOrderBy: " + employeeRepository.findBySalaryGreaterThanEqualOrderBy(100000));
//
//        System.out.println("findBySalaryLessThanEqual: " + employeeRepository.findBySalaryLessThanEqual(100000));
//
//        System.out.println("findTop1BySalaryOrderBySalary: " + employeeRepository.findDistinctTop1BySalaryOrderBySalary());


        System.out.println("--------Employees ends--------------");

    }

}
