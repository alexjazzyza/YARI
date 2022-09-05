package com.doranco.yari.authentication;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IApplicationUserService extends UserDetailsService {

    public String getUsername();
}
