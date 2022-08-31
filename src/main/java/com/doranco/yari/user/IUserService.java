package com.doranco.yari.user;

import com.doranco.yari.vehicle.EVehicleType;
import com.doranco.yari.vehicle.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    public User saveUser(User user);
    public User updateUser(User user);
    public User deleteUser(Integer idUser) throws Exception;
    public User getUserById(Integer idUser) throws Exception;
    public User getUsersByType(EUserType userType);
    public Page<User> getAllUsers(Pageable pageable);
}
