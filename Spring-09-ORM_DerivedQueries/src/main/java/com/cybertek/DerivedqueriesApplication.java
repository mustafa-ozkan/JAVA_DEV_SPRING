package com.cybertek;

import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {

	@Autowired
	RegionRepository regionRepository;

	public static void main(String[] args) {
		SpringApplication.run(DerivedqueriesApplication.class, args);
	}

	@PostConstruct
	public void testRegions(){
		System.out.println("--------Regions start--------------");

		System.out.println("find by country: "+regionRepository.findByCountry("Canada"));

		System.out.println("find distinct by country: "+regionRepository.findDistinctByCountry("Canada"));

		System.out.println("find country names containing by country: "+regionRepository.findAllByCountryContaining("United"));








		System.out.println("--------Regions ends--------------");

	}

}
