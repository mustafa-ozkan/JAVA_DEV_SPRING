package com.cybertek;

import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args);
	}

	@PostConstruct
	public void testEmployeeNamedQueries(){

		System.out.println("---------Employees starts-------------");
		System.out.println("select e from Employee e where e.email='dtrail8@tamu.edu' :"+employeeRepository.getEmployeeDetail());

		System.out.println("select e.salary from Employee e where e.email='dtrail8@tamu.edu' :"+employeeRepository.getEmployeeSalary());



	}

}
