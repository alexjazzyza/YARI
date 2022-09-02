package com.doranco.yari.user.staff;

import com.doranco.yari.user.User;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Staff extends User {

    public Staff(String username, String password){

        super(username, password);
        /*setFirstName("Pierre");
        setLastName("Brun");
        setAddress("40 Avenue Reille, 75014 Paris");
        setEmail("p.brun@gmail.com");*/
    }

}
