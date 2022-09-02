package com.doranco.yari.user.authority;

import com.doranco.yari.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    public List<Authority> findAuthoritiesByUsersContains(User user);

}
