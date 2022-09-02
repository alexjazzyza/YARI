package com.doranco.yari.user.customer;

import com.doranco.yari.reservation.Reservation;
import com.doranco.yari.user.User;
import com.doranco.yari.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer extends User {

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Reservation> reservations;

    public Customer(String username, String password){
        super(username, password);
        /*setFirstName("Marcel");
        setLastName("Petitgros");
        setAddress("149 BAvenue du Maréchal Leclerc, 33000 Bordeaux");
        setEmail("m.petitgros@gmail.com");*/
    }
}
