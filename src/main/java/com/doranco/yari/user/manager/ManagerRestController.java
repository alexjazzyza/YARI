package com.doranco.yari.user.manager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/managers")
public class ManagerRestController {

    private final IManagerService managerService;

    public ManagerRestController(IManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public Page<Manager> getManagerPage(@RequestParam(name="size", defaultValue="10") int size,
                                          @RequestParam(name="page", defaultValue = "0") int page) {

        Page<Manager> managers = null;

        try{
            managers = managerService.getAllManagers(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return managers;
    }

    @PostMapping
    public Manager saveManager(@RequestBody Manager customer) {

        Manager m = null;
        try {
            m = managerService.saveManager(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return m;
    }

    @PutMapping("/{idUser}")
    public Manager updateManager(@PathVariable Long idUser, @RequestBody Manager manager) {

        Manager m = null;
        try {
            m = managerService.updateManager(manager);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return m;
    }

    @DeleteMapping("/{idUser}")
    public Manager deleteManager(@PathVariable Long idUser) {

        Manager manager = null;

        try {
            manager = managerService.deleteManager(idUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return manager;
    }

    @GetMapping("/getById")
    public Manager getManagerById(@RequestParam(name="idUser") Long idUser) {

        Manager manager = null;

        try {
            manager = managerService.getManagerById(idUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return manager;
    }
}
