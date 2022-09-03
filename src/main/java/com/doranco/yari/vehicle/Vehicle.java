package com.doranco.yari.vehicle;

import com.doranco.yari.agency.Agency;
import com.doranco.yari.reservation.Reservation;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @Column(name="refVehicle", length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refVehicle;
    private String brand;
    private String model;
    @Enumerated(EnumType.STRING)
    private EVehicleType vehicleType;
    private String gearbox;
    private Integer nbSeats;
    private Integer nbDoors;
    private Integer volume;
    private Float priceCoeff;

    @OneToMany(mappedBy = "vehicle")
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="agency", nullable = false)
    private Agency agency;

}
