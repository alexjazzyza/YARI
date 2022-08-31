package com.doranco.yari.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(Integer idCustomer) throws Exception {
        Customer customer = getCustomerById(idCustomer);
        customerRepository.deleteById(idCustomer);
        return customer;
    }

    @Override
    public Customer getCustomerById(Integer idCustomer) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(idCustomer);
        if (customerOptional.isPresent())
        {
            return customerOptional.get();
        }
        else
            throw new RuntimeException("Customer not found.");
    }

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
