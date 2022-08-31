package com.doranco.yari.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    public Customer saveCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Integer idCustomer) throws Exception;
    public Customer getCustomerById(Integer idCustomer) throws Exception;
    public Page<Customer> getAllCustomers(Pageable pageable);
}
