package com.doranco.yari.reservation;

import com.doranco.yari.vehicle.Vehicle;
import lombok.*;

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
    private String idReservation;
    private double amount;
    @Temporal(TemporalType.DATE)
    private Date startDate = new Date();
    @Temporal(TemporalType.DATE)
    private Date endDate = new Date();
    @ManyToOne
    private Vehicle vehicle;
}
