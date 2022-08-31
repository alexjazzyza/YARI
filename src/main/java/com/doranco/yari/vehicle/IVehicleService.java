package com.doranco.yari.vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVehicleService {

    public Vehicle saveVehicle(Vehicle vehicle);
    public Vehicle updateVehicle(Vehicle vehicle);
    public Vehicle deleteVehicle(String refVehicle) throws Exception;
    public Vehicle getVehicleById(String refVehicle) throws Exception;
    public Vehicle getVehiclesByType(EVehicleType vehicleType);
    public Page<Vehicle> getAllVehicles(Pageable pageable);

    public Vehicle changeVehicleAvailability(String refVehicle, boolean availability);
}
