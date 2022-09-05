package com.doranco.yari.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements IApplicationUserService {

    private final ApplicationUserDao applicationUserDao;
    private final IAuthenticationFacade authenticationFacade;

    public ApplicationUserService(ApplicationUserDao applicationUserDao, IAuthenticationFacade authenticationFacade) {
        this.applicationUserDao = applicationUserDao;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao.getUserByUsername(username);
    }

    public String getUsername() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }


}
