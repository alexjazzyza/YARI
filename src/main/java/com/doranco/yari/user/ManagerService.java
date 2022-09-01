package com.doranco.yari.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService implements IManagerService{

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager deleteManager(Long idUser) throws Exception {
        Manager manager = getManagerById(idUser);
        managerRepository.deleteById(idUser);
        return manager;
    }

    @Override
    public Manager getManagerById(Long idUser) throws Exception {
        Optional<Manager> managerOptional = managerRepository.findById(idUser);
        if(managerOptional.isPresent())
        {
            return managerOptional.get();
        }
        else
        {
            throw new RuntimeException("Manager not found.");
        }
    }

    @Override
    public Page<Manager> getAllManagers(Pageable pageable) throws Exception {
        return managerRepository.findAll(pageable);
    }

}
