package com.doranco.yari.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IManagerService {

    public Manager saveManager(Manager manager);
    public Manager updateManager(Manager manager);
    public Manager deleteManager(Long idUser) throws Exception;
    public Manager getManagerById(Long idUser) throws Exception;
    public Page<Manager> getAllManagers(Pageable pageable) throws Exception;
}