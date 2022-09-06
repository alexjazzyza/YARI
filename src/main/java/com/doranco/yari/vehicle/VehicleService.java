package com.doranco.yari.vehicle;

import com.doranco.yari.agency.Agency;
import com.doranco.yari.agency.ECities;
import com.doranco.yari.reservation.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
    public Vehicle deleteVehicle(Long refVehicle) throws Exception {
        Vehicle vehicle = getVehicleById(refVehicle);
        vehicleRepository.deleteById(refVehicle);
        return vehicle;
    }

    @Override
    public Vehicle getVehicleById(Long refVehicle) throws Exception {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(refVehicle);
        if (vehicleOptional.isPresent()) {
            return vehicleOptional.get();
        } else
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

    @Override
    public List<Vehicle> getAvailableVehicle(ECities city, Date dateDeb, Date dateF, EVehicleType t) throws Exception {
        //filtrer les vehicules par agence
        //filtrer les vehicules par typeVehicule
        List<Vehicle> availableVehicles = new ArrayList<>();

        List<Vehicle> listVehicleBytype = new ArrayList<>();
        listVehicleBytype = vehicleRepository.findVehicleByVehicleType(t);

        if (!dateDeb.after(dateF))
        {
            for (Vehicle vehicle :
                    listVehicleBytype) {

                if (vehicle.getAgency().getCity().name().equals(city.name())) {

                    int i = 0;
                    Date current = dateDeb;
                    while (current.before(dateF)) {
                        Date dateDebutRes, dateFinRes = null;
                        for (Reservation reservation : vehicle.getReservations()) {
                            dateDebutRes = reservation.getStartDate(); //.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                            dateFinRes = reservation.getEndDate();
                            if ((current.after(dateDebutRes) || current.equals((dateDebutRes))) && (current.before(dateFinRes) || current.equals(dateFinRes))) {
                                i = 1;
                                break;
                            }
                        }
                        if(i == 1)
                        {
                            break;
                        }
                        current = new Date(current.getTime() + (1000 * 60 * 60 * 24));
                    }
                    if (i == 0) {
                        availableVehicles.add(vehicle);
                    }
                }
            }
        }
        else
        {
            Vehicle empty = new Vehicle();
            empty.setBrand("invalid");
            availableVehicles.add(empty);
        }
        return availableVehicles;
    }
}
