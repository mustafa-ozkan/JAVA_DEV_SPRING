package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    //Display All regions in Canada

    List<Region> findByCountry(String country);

    //display all regions in canada, without duplicates

    List<Region> findDistinctByCountry(String country);

    //display all regions with country name includes "United"

    List<Region> findAllByCountryContaining(String string);


}
