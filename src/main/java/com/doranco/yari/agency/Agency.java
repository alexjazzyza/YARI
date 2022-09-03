package com.doranco.yari.agency;

import com.doranco.yari.reservation.Reservation;
import com.doranco.yari.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agency {

    @Id
    @Column(name="id_agency", length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgency;

    @Column(length = 50)
    private String agencyName;

    @Enumerated(EnumType.STRING)
    private ECities city;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agency")
    private List<Vehicle> vehicles;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agency")
    private List<Reservation> reservations;

}
