package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(DerivedqueriesApplication.class, args);
	}

	@PostConstruct
	public void testRegions(){
		System.out.println("--------Regions start--------------");

		System.out.println("find by country: "+regionRepository.findByCountry("Canada"));

		System.out.println("find distinct by country: "+regionRepository.findDistinctByCountry("Canada"));

		System.out.println("find country names containing by country: "+regionRepository.findAllByCountryContaining("United"));

		System.out.println("find country names containing by country order by region: "+regionRepository.findAllByCountryContainingOrderByRegion("United"));

		System.out.println("find top 2 by country: "+regionRepository.findTop2ByCountry("United States"));








		System.out.println("--------Regions ends--------------");

		System.out.println("--------Departments start--------------");

		System.out.println("findByDivision: "+departmentRepository.findByDivision("Health"));

		System.out.println("findByDepartment: "+departmentRepository.findByDepartment("Health"));

		System.out.println("findByDivisionEquals: "+departmentRepository.findByDivisionEquals("Health"));

		System.out.println("findByDivisionEndsWith: "+departmentRepository.findByDivisionEndsWith("ics"));

		System.out.println("findDistinctTop3ByDivisionContains: "+departmentRepository.findDistinctTop3ByDivisionContains("Hea"));








		System.out.println("--------Department ends--------------");

	}

}
