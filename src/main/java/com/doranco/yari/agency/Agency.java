package com.doranco.yari.agency;

import com.doranco.yari.vehicle.Vehicle;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agency {

    @Id
    @Column(name="id_agency", length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgency;
    private ECities city;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agency")
    private List<Vehicle> vehicleList;

}
