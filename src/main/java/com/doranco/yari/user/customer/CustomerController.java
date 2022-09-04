package com.doranco.yari.user.customer;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CustomerController {

    private final ICustomerService customerService;
    private final UserDetailsService userDetailsService;

    public CustomerController(ICustomerService customerService, UserDetailsService userDetailsService) {
        this.customerService = customerService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/subscription")
    public String subscribe(Model model) {
        model.addAttribute("customer", new Customer());
        return "subscription";
    }

    @PostMapping("/confirmSubscription")
    public String confirmSubscription(@Valid Customer customer, BindingResult bindingResult, Model model) {

        /*UserDetails userDetails = User.builder().username(customer.getUsername()).password()*/
        customer = customerService.saveCustomer(customer);
        model.addAttribute("customer", customer);
        return "confirm_subscription";
    }
}
