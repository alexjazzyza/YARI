package com.doranco.yari.vehicle;

import com.doranco.yari.agency.ECities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    public List<Vehicle>findVehicleByVehicleType(EVehicleType t) throws Exception;
    public List<Vehicle>findVehicleByAgency(ECities city);

}
