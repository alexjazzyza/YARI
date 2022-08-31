package com.doranco.yari.reservation;

import com.doranco.yari.vehicle.Vehicle;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private String idReservation;
    private double amount;
    private Date startDate = new Date();
    private Date endDate = new Date();
    @ManyToOne
    private Vehicle vehicle;
}
