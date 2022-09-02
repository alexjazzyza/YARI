package com.doranco.yari.reservation;

import com.doranco.yari.agency.Agency;
import com.doranco.yari.user.customer.Customer;
import com.doranco.yari.vehicle.Vehicle;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

    @Id
    @Column(length = 10)
    private Long idReservation;

    private double price;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate = new Date();

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Agency agency;
}
