package com.doranco.yari.user.manager;

import com.doranco.yari.user.User;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Manager extends User {

    public Manager(String username, String password){

        super(username, password);
        /*setFirstName("Alex");
        setLastName("Stigspiel");
        setAddress("10 rue de Seine, 75006 Paris");
        setEmail("a.stigspiel@gmail.com");*/
    }

}
