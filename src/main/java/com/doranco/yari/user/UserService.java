package com.doranco.yari.user;

import com.doranco.yari.vehicle.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Integer idUser) throws Exception {
        User user = getUserById(idUser);
        userRepository.deleteById(idUser);
        return user;
    }

    @Override
    public User getUserById(Integer idUser) throws Exception {
        Optional<User> userOptional = userRepository.findById(idUser);
        if (userOptional.isPresent())
        {
            return userOptional.get();
        }
        else
            throw new RuntimeException("User not found.");
    }

    @Override
    public User getUsersByType(EUserType userType) {
        return null;
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return null;
    }
}
