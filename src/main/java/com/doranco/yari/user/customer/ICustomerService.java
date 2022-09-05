package com.doranco.yari.user.customer;

import com.doranco.yari.user.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICustomerService {

    public Customer saveCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Long idUser) throws Exception;
    public Customer getCustomerById(Long idUser) throws Exception;
    public Customer getCustomerByUsername(String username);
    public Page<Customer> getAllCustomers(Pageable pageable);
}
