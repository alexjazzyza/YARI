package com.doranco.yari.user.admin;

import com.doranco.yari.user.User;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Admin extends User {

    public Admin(String username, String password){

        super(username, password);
        /*setFirstName("Jean");
        setLastName("Du Fiacre");
        setAddress("12 rue du Cherche-Midi, 75006 Paris");
        setEmail("j.dufiacre@gmail.com");*/
    }
}
