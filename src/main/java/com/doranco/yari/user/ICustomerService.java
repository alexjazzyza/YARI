package com.doranco.yari.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    public Customer saveCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Long idUser) throws Exception;
    public Customer getCustomerById(Long idUser) throws Exception;
    public Page<Customer> getAllCustomers(Pageable pageable);
}
