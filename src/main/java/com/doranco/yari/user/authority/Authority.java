package com.doranco.yari.user.authority;

import com.doranco.yari.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "role", joinColumns = @JoinColumn(name = "id_auth"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;

    public Authority(String name) {
        this.name = name;
        users = new ArrayList<>();
    }
}
