package com.doranco.yari.authentication;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IAuthenticationFacade {

    public void login (HttpServletRequest req, String username, String password);
    public Authentication getAuthentication();
}
