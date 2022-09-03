package com.doranco.yari.vehicle;

import com.doranco.yari.agency.ECities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IVehicleService {

    public Vehicle saveVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Vehicle vehicle);
    public Vehicle deleteVehicle(Long refVehicle) throws Exception;
    public Vehicle getVehicleById(Long refVehicle) throws Exception;
    public Vehicle getVehiclesByType(EVehicleType vehicleType);
    public Page<Vehicle> getAllVehicles(Pageable pageable);
    public List<Vehicle> getAvailableVehicle(ECities agency, Date dateDeb , Date dateF , EVehicleType t) throws Exception;

}
