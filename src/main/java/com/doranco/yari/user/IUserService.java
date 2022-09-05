package com.doranco.yari.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    public User saveUser(User user);
    public User updateUser(User user);
    public User deleteUser(Long idUser) throws Exception;
    public User getUserById(Long idUser) throws Exception;
    public User getUserByUsername(String username);
    public Page<User> getAllUsers(Pageable pageable) throws Exception;

}
