package com.doranco.yari.user;

import com.doranco.yari.vehicle.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    private final ICustomerService customerService;

    public CustomerRestController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Page<Customer> getCustomerPage(@RequestParam(name="size", defaultValue="10") int size,
                                          @RequestParam(name="page", defaultValue = "0") int page) {

        Page<Customer> customers = null;

        try{
            customers = customerService.getAllCustomers(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {

        Customer c = null;
        try {
            c = customerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    @PutMapping("/{idCustomer}")
    public Customer updateCustomer(@PathVariable Integer idCustomer, @RequestBody Customer customer) {

        Customer c = null;
        try {
            c = customerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    @DeleteMapping("/{idCustomer}")
    public Customer deleteCustomer(@PathVariable Integer idCustomer) {

        Customer customer = null;

        try {
            customer = customerService.deleteCustomer(idCustomer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @GetMapping("/getById")
    public Customer getCustomerById(@RequestParam Integer idCustomer) {

        Customer customer = null;

        try {
            customer = customerService.getCustomerById(idCustomer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}
