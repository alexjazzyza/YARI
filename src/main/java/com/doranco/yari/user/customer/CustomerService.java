package com.doranco.yari.user.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    @Override
    public Customer saveCustomer(Customer customer) {

        customer.setAccountNonExpired(true);
        customer.setAccountNonLocked(true);
        customer.setEnabled(true);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(Long idUser) throws Exception {
        Customer customer = getCustomerById(idUser);
        customerRepository.deleteById(idUser);
        return customer;
    }

    @Override
    public Customer getCustomerById(Long idUser) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(idUser);
        if (customerOptional.isPresent())
        {
            return customerOptional.get();
        }
        else
        {
            throw new RuntimeException("Customer not found.");
        }
    }

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }



}
