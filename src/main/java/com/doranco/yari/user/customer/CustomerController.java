package com.doranco.yari.user.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/subscription")
    public String subscribe(Model model) {
        model.addAttribute("customer", new Customer());
        return "subscription";
    }

    @PostMapping("/confirmSubscription")
    public String confirmSubscription(@Valid Customer customer, BindingResult bindingResult, Model model) {

        customer = customerService.saveCustomer(customer);
        model.addAttribute("customer", customer);
        return "confirm_subscription";
    }
}
