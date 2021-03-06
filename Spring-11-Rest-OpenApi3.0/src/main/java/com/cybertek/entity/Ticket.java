package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
public class Ticket extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "Ticket{" +
                "dateTime=" + dateTime +
                ", seatNumber=" + seatNumber +
                ", rowNumber=" + rowNumber +
                '}';
    }

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "row_number")
    private Integer rowNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "movie_cinema_id")
    private MovieCinema movieCinema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "user_account_id")
    private UserAccount userAccount;

    public Ticket(Integer seatNumber, Integer rowNumber,LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
    }
}
