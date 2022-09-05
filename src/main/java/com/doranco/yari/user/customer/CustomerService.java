package com.doranco.yari.user.customer;

import com.doranco.yari.user.authority.Authority;
import com.doranco.yari.user.authority.AuthorityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(ICustomerRepository customerRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Customer saveCustomer(Customer customer) {

        /*UserDetails userDetails = User.builder().username(customer.getUsername()).password(passwordEncoder.encode(customer.getPassword())).*/
        customer.setAccountNonExpired(true);
        customer.setAccountNonLocked(true);
        customer.setCredentialsNonExpired(true);
        customer.setEnabled(true);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        customer = customerRepository.save(customer);

        Authority roleCustomer = authorityRepository.findAuthorityByName("ROLE_CUSTOMER");
        roleCustomer.getUsers().add(customer);

        Authority auth_vehicle_read = authorityRepository.findAuthorityByName("vehicle:read");
        Authority auth_reservation_read = authorityRepository.findAuthorityByName("reservation:read");
        Authority auth_reservation_write = authorityRepository.findAuthorityByName("reservation:write");
        Authority auth_reservation_delete = authorityRepository.findAuthorityByName("reservation:delete");

        auth_vehicle_read.getUsers().add(customer);
        auth_reservation_read.getUsers().add(customer);
        auth_reservation_write.getUsers().add(customer);
        auth_reservation_delete.getUsers().add(customer);

        authorityRepository.save(auth_vehicle_read);
        authorityRepository.save(auth_reservation_read);
        authorityRepository.save(auth_reservation_write);
        authorityRepository.save(auth_reservation_delete);

        return customer;
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
    public Customer getCustomerByUsername(String username) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByUsername(username);
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
