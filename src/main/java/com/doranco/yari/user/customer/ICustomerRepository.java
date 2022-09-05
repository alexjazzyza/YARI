package com.doranco.yari.user.customer;

import com.doranco.yari.user.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    public Optional<Customer> findCustomerByUsername(String username);
}
