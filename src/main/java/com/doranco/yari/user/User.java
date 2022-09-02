package com.doranco.yari.user;

import com.doranco.yari.user.authority.Authority;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
    private String lastName;
    private String firstName;
    @Column(length = 30)
    private String username;
    private String password;
    private String address;
    private String email;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Authority> authorities;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }


}
