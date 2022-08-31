package com.doranco.yari.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class User {

    @Id
    private Integer idUser;
    private String lastName;
    private String firstName;
    private String login;
    private String password;
    private String address;
    private String email;
    private EUserType userType;

}
