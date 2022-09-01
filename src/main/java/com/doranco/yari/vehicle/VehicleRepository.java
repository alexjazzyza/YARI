package com.doranco.yari.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
public List<Vehicle>findVehicleByVehicleType(EVehicleType t);
    public List<Vehicle>findVehicleByAgency();

}
