package com.cybertek.repository;

import com.cybertek.entity.AccountDetail;
import com.cybertek.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail,Long> {
// ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to list all accounts with a specific country or state

    List<AccountDetail> findAllByCountryOrState(String country, String state);

//Write a derived query to list all accounts with age lower than or equal to a specific value

    List<AccountDetail> findAllByAgeLessThanEqual(Integer age);

//Write a derived query to list all accounts with a specific role
    List<AccountDetail> findAllByRole(UserRole role);

//Write a derived query to list all accounts between a range of ages
    List<AccountDetail> findAllByAgeBetween(Integer minAge,Integer maxAge);

//Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetail> findAllByAddressStartingWith(String address);
//Write a derived query to sort the list of accounts with age

    List<AccountDetail> findByOrderByAgeDesc();
// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query that returns all accounts

    @Query("select ad from AccountDetail ad")
    List<AccountDetail> getAllAccounts();

//Write a JPQL query to list all admin accounts

    @Query("select ad from AccountDetail ad where ad.role = 'USER'")
    List<AccountDetail> getAllAdminAccounts();

//Write a JPQL query to sort all accounts with age
    @Query("select ad from AccountDetail ad order by ad.age desc")
    List<AccountDetail> getAllOrderByAge();

// ------------------- Native QUERIES ------------------- //
//Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "select * from account_details where age<?1create table account_details(	age int);", nativeQuery = true)
    List<AccountDetail> retrieveAllByAgeLessThan(Integer age);

//Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details where name ILIKE concat('%',?1,'%')"+
            " or country ILIKE concat('%',?1,'%') or address ILIKE concat('%',?1,'%')"+
    " or state ILIKE concat('%',?1,'%')"+
    " or city ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<AccountDetail> retrieveAllBySearchCriteria(String pattern);


//Write a native query to read all accounts with an age more than a specific value
    @Query(value = "select * from account_details where age>?1",nativeQuery = true)
    List<AccountDetail> retrieveAllByAgeGreaterThan(Integer age);
}
