package com.doranco.yari.user.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
