package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //display all employees with email address ""
    List<Employee> findByEmail(String email);

    //display all employees with first name "" and last name "" also show all employees with email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);

    //display all employees that firstname is not ""
    List<Employee> findByFirstNameNot(String firstName);

    //display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all employees with salaries less  than ""
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //display max salary
    Employee findDistinctTop1BySalaryOrderBySalary();

    //display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);


    //display all employees where salaries greater and equal to  "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBy(Integer salary);

    //display  top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);


    // display alll employees that do not have email address
    List<Employee> findAllByEmailIsNull();




}
