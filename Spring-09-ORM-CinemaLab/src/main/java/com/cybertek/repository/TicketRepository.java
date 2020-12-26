package com.cybertek.repository;

import com.cybertek.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);
//Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);
//Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);
//Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime minDateTime, LocalDateTime maxDateTime);

// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.userAccount.id=?1")
    List<Ticket> fetchAllTicketsFromAUser(Long userId);
//Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> fetchAllTicketsBetweenDates(LocalDateTime minDate, LocalDate maxDate);
// ------------------- Native QUERIES ------------------- //
//Write a native query to count the number of tickets a user bought
    @Query(value = "select count(*) from ticket t join user_account ua on t.user_account_id = ua.id where ua.username =?1", nativeQuery = true)
    Integer retrieveCountofTicketsForAUser(String userName);
//Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select count(*) from ticket t join user_account ua on t.user_account_id = ua.id " +
            "where ua.username =?1 and t.date_time between ?2 and ?3", nativeQuery = true)
    Integer retrieveCountOfTicketsForAUserBetweenSpecificDates(String username, LocalDateTime minDate,
                                                               LocalDate maxDate );

//Write a native query to distinct all tickets by movie name

//Write a native query to find all tickets by user email
//Write a native query that returns all tickets
//Write a native query to list all tickets where a specific value should be containable in the username or name or movie name



}
