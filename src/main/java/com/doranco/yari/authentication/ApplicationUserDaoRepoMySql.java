package com.doranco.yari.authentication;

import com.doranco.yari.user.authority.Authority;
import com.doranco.yari.user.authority.AuthorityRepository;
import com.doranco.yari.user.User;
import com.doranco.yari.user.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ApplicationUserDaoRepoMySql implements ApplicationUserDao {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    public ApplicationUserDaoRepoMySql(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public ApplicationUserDetail getUserByUsername(String username) {

        User user = userRepository.findByUsername(username);
        List<Authority> authorities = authorityRepository.findAuthoritiesByUsersContains(user);
        Set<SimpleGrantedAuthority> grantedAuthorities = authorities .stream().map(authority -> new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toSet());

       /* Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }*/

        ApplicationUserDetail userDetail = new ApplicationUserDetail(user.getPassword(), user.getUsername(), grantedAuthorities, true, true, true, true);
        return userDetail;
    }
}
