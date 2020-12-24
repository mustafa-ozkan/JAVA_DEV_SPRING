package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.email='dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email='dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    //Single bind parameter
    @Query("select e from Employee e where e.email = ?1")
    Optional<Employee> getEmployeeByEmail(String email);

    //multiple bind parameter
    @Query ("select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeByEmailAndSalary(String email, int salary);

    //single named parameter
    @Query("select e from Employee e where e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    //multiple named parameters
    @Query("select e from Employee e where e.firstName=:name or e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("salary") int salary, @Param("name") String firstName);


    //not equal
    @Query("select e from Employee e where e.salary <> :salary")
    List<Employee> getEmployeeBySalaryNotEqual(@Param("salary") int salary);

    //Like/contains/startswith/ends with
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    //less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //greater than
    @Query("select e from Employee e where e.salary>?1")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);

    //between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeBySalaryBetween(int minSalary, int maxSalary);

    //before
    @Query("select e from Employee e where e.hireDate>?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //null
    @Query("select e from Employee e where e.email is null")
    List<Employee> getEmployeeByEmailIsNull();

    //notnull
    @Query("select e from Employee e where e.email is not null")
    List<Employee> getEmployeeByEmailIsNotNull();

    //sort salary in descending order(Ascending is the default order)
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> getEmployeeSalaryOrderByDesc();

    //Native Query --table names and column nMES MUST BE FROM THE DATABASE TABLES
    @Query(value = "select * from employees where salary = ?1",nativeQuery = true)
    List<Employee> readEmployeeBySalary(int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e set e.email ='admin@email.com' where e.id=:id")
    void updateEmployeeJPQL(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update employees set email= 'admin@email.com' where employee_id =:id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);

    //named query
    List<Employee> retrieveEmployeeSalaryGreaterThan(int salary);





}
