package com.doranco.yari.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
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
    public User deleteUser(Long idUser) throws Exception {
        User user = getUserById(idUser);
        userRepository.deleteById(idUser);
        return user;
    }

    @Override
    public User getUserById(Long idUser) throws Exception{
        Optional<User> userOptional = userRepository.findById(idUser);
        if(userOptional.isPresent())
        {
            return userOptional.get();
        }
        else
        {
                throw new RuntimeException("Manager not found.");
        }
    }

    @Override
    public User getUserByName(Long idUser) throws Exception {
        return null;
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) throws Exception{
        return userRepository.findAll(pageable);
    }

}
