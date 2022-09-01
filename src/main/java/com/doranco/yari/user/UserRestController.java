package com.doranco.yari.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final IUserService userService;

    public UserRestController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<User> getUserPage(@RequestParam(name="size", defaultValue="10") int size,
                                        @RequestParam(name="page", defaultValue = "0") int page) {

        Page<User> users = null;

        try {
            users = userService.getAllUsers(PageRequest.of(page, size));
            System.out.println("----------------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }

   /* @GetMapping
    public Page<Manager> getManagerPage(@RequestParam(name="size", defaultValue="10") int size,
                                  @RequestParam(name="page", defaultValue = "0") int page) {

        Page<Manager> managers = null;

        try {
            managers = userService.getAllManagers(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return managers;
    }*/

    @PostMapping
    public User saveUser(@RequestBody User user) {
        User u = null;
        u = userService.saveUser(user);
        return u;
    }

    @PutMapping("/{idUser}")
    public User updateUser(@PathVariable Long idUser, @RequestBody User user) {
        User u = null;
        u = userService.updateUser(user);
        return u;
    }

    @DeleteMapping("/{idUser}")
    public User deleteUser(@PathVariable Long idUser) {
        User u = null;
        try {
            u = userService.deleteUser(idUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    @GetMapping("/getById")
    public User getUserById(@RequestParam(name="idUser") Long idUser) {
        User u = null;
        try {
            u = userService.getUserById(idUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return u;
    }
}
