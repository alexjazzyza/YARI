package com.doranco.yari.vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle deleteVehicle(String refVehicle) throws Exception {
        Vehicle vehicle = getVehicleById(refVehicle);
        vehicleRepository.deleteById(refVehicle);
        return vehicle;
    }

    @Override
    public Vehicle getVehicleById(String refVehicle) throws Exception {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(refVehicle);
        if (vehicleOptional.isPresent())
        {
            return vehicleOptional.get();
        }
        else
            throw new RuntimeException("Vehicle not found.");
    }

    @Override
    public Vehicle getVehiclesByType(EVehicleType vehicleType) {
        return null;
    }

    @Override
    public Page<Vehicle> getAllVehicles(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

}
