package com.doranco.yari.vehicle;

import com.doranco.yari.agency.Agency;
import com.doranco.yari.reservation.Reservation;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {

    @Id
    @Column(name="ref_vehicle", length = 10)
    private String refVehicle;
    private String brand;
    private String model;
    private EVehicleType vehicleType;
    private String gearbox;
    private Integer nbSeats;
    private Integer nbDoors;
    private Integer volume;
    private boolean availability;
    private Float priceCoeff;
    @ManyToOne
    private Agency agency;

  /*  @OneToMany
    private List<Reservation> reservations;*/

}
