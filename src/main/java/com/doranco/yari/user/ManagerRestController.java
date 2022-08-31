package com.doranco.yari.user;

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

        try {
            managers = managerService.getAllManagers(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return managers;
    }

    @PostMapping
    public Manager saveManager(@RequestBody Manager manager) {
        Manager m = null;
        m = managerService.saveManager(manager);
        return m;
    }

    @PutMapping("/{idUser}")
    public Manager updateManager(@PathVariable Long idUser, @RequestBody Manager manager) {
        Manager m = null;
        m = managerService.updateManager(manager);
        return m;
    }

    @DeleteMapping("/{idUser}")
    public Manager deleteManager(@PathVariable Long idUser) {
        Manager m = null;
        try {
            m = managerService.deleteManager(idUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return m;
    }

    @GetMapping("/getById")
    public Manager getManagerById(@RequestParam(name="idUser") Long idUser) {
        Manager m = null;
        try {
            m = managerService.getManagerById(idUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return m;
    }
}
