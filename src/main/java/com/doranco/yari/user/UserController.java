package com.doranco.yari.user;

import com.doranco.yari.authentication.ApplicationUserService;
import com.doranco.yari.user.customer.Customer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final IUserService userService;
    private final ApplicationUserService applicationUserService;

    public UserController(IUserService userService, ApplicationUserService applicationUserService) {
        this.userService = userService;
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/authentication")
    public String subscribe(Model model) {
        return "authentication";
    }

    @PostMapping("/ConfirmAuthentication")
    public String authentication(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 Model model) {

        UserDetails userDetails = applicationUserService.loadUserByUsername(username);
        System.out.println("ted");
        return "index";
    }
}
