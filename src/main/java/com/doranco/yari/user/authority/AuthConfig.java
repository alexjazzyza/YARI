package com.doranco.yari.user.authority;

import com.doranco.yari.user.User;
import com.doranco.yari.user.UserRepository;
import com.doranco.yari.user.admin.Admin;
import com.doranco.yari.user.customer.Customer;
import com.doranco.yari.user.manager.Manager;
import com.doranco.yari.user.staff.Staff;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthConfig(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }



    /*@Bean
    CommandLineRunner init_user() {
        return args -> {
            User user_admin = userRepository.save(new Admin("admin", passwordEncoder.encode("admin")));
            User user_manager = userRepository.save(new Manager("manager", passwordEncoder.encode("manager")));
            User user_staff = userRepository.save(new Staff("staff", passwordEncoder.encode("staff")));
            User user_customer = userRepository.save(new Customer("customer", passwordEncoder.encode("customer")));
            Authority auth_user_write = authorityRepository.save(new Authority("user:write"));
            Authority auth_user_read = authorityRepository.save(new Authority("user:read"));
            Authority auth_user_delete = authorityRepository.save(new Authority("user:delete"));
            Authority auth_agency_write = authorityRepository.save(new Authority("agency:write"));
            Authority auth_agency_read = authorityRepository.save(new Authority("agency:read"));
            Authority auth_agency_delete = authorityRepository.save(new Authority("agency:delete"));
            Authority auth_vehicle_write = authorityRepository.save(new Authority("vehicle:write"));
            Authority auth_vehicle_read = authorityRepository.save(new Authority("vehicle:read"));
            Authority auth_vehicle_delete = authorityRepository.save(new Authority("vehicle:delete"));
            Authority auth_reservation_write = authorityRepository.save(new Authority("reservation:write"));
            Authority auth_reservation_read = authorityRepository.save(new Authority("reservation:read"));
            Authority auth_reservation_delete = authorityRepository.save(new Authority("reservation:delete"));
            Authority role_admin = authorityRepository.save(new Authority("ROLE_ADMIN"));
            Authority role_manager = authorityRepository.save(new Authority("ROLE_MANAGER"));
            Authority role_staff = authorityRepository.save(new Authority("ROLE_STAFF"));
            Authority role_customer = authorityRepository.save(new Authority("ROLE_CUSTOMER"));
            role_admin.getUsers().add(user_admin);
            authorityRepository.save(role_admin);
            role_manager.getUsers().add(user_manager);
            authorityRepository.save(role_manager);
            role_staff.getUsers().add(user_staff);
            authorityRepository.save(role_staff);
            role_customer.getUsers().add(user_customer);
            authorityRepository.save(role_customer);
            // ----------- USER AUTHORITY -----------
            auth_user_write.getUsers().add(user_admin);
            authorityRepository.save(auth_user_write);
            auth_user_read.getUsers().add(user_admin);
            auth_user_read.getUsers().add(user_manager);
            authorityRepository.save(auth_user_read);
            auth_user_delete.getUsers().add(user_admin);
            authorityRepository.save(auth_user_delete);
            // ----------- AGENCY AUTHORITY -----------
            auth_agency_write.getUsers().add(user_admin);
            authorityRepository.save(auth_agency_write);
            auth_agency_read.getUsers().add(user_admin);
            authorityRepository.save(auth_agency_read);
            auth_agency_delete.getUsers().add(user_admin);
            authorityRepository.save(auth_agency_delete);
            // ----------- VEHICLE AUTHORITY -----------
            auth_vehicle_write.getUsers().add(user_admin);
            auth_vehicle_write.getUsers().add(user_manager);
            authorityRepository.save(auth_vehicle_write);
            auth_vehicle_read.getUsers().add(user_admin);
            auth_vehicle_read.getUsers().add(user_manager);
            auth_vehicle_read.getUsers().add(user_staff);
            auth_vehicle_read.getUsers().add(user_customer);
            authorityRepository.save(auth_vehicle_read);
            auth_vehicle_delete.getUsers().add(user_admin);
            auth_vehicle_delete.getUsers().add(user_manager);
            authorityRepository.save(auth_vehicle_delete);
            // ----------- RESERVATION AUTHORITY -----------
            auth_reservation_write.getUsers().add(user_admin);
            auth_reservation_write.getUsers().add(user_manager);
            auth_reservation_write.getUsers().add(user_staff);
            authorityRepository.save(auth_reservation_write);
            auth_reservation_read.getUsers().add(user_admin);
            auth_reservation_read.getUsers().add(user_manager);
            auth_reservation_read.getUsers().add(user_staff);
            auth_reservation_read.getUsers().add(user_customer);
            authorityRepository.save(auth_reservation_read);
            auth_reservation_delete.getUsers().add(user_admin);
            auth_reservation_delete.getUsers().add(user_manager);
            auth_reservation_delete.getUsers().add(user_staff);
            authorityRepository.save(auth_reservation_delete);
        };
    }*/
}