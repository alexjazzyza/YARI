package com.doranco.yari.vehicle;

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



    @Override
    public List<Vehicle> getAvailbaleVehicle(Agency agency, Date dateDeb , Date dateF , EVehicleType t) throws Exception {
        //filtrer les vehicules par agence
        //filtrer les vehicules par typeVehicule
        List<Vehicle>listAvailbaleVehicle=new ArrayList<>();

        List<Vehicle>listVehicleBytype=new ArrayList<>();

        listVehicleBytype=vehicleRepository.findVehicleByVehicleType(t);

      //  List<Reservation> listeDesReservation=new ArrayList<>();

        for (Vehicle v :
                listVehicleBytype) {

            if(v.getAgency().equals(agency)){

                //listeDesReservation=v.getReservations();


                int i = 0;
                LocalDate fromDateCustomer, toDateCustomer = null;
                fromDateCustomer = dateDeb.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                toDateCustomer = dateF.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate current = fromDateCustomer;
                while (current.isBefore(toDateCustomer)) {
                    current = current.plusDays(1);

                    LocalDate dateDebutRes, dateFinRes = null;

                    //for (Reservation r:listeDesReservation) {


                        for (Reservation r:v.getReservations()) {
                            dateDebutRes = r.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            dateFinRes = r.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            if (current.isAfter(dateDebutRes) && current.isBefore(dateFinRes)) {
                                i = 1;
                                break;
                            }
                        }
                    }
                    if (i == 0) {
                        listAvailbaleVehicle.add(v);
                    } else {
                        throw new RuntimeException("Vehicle not available.");
                    }

            }
        }

        return listAvailbaleVehicle ;





    }

    @Override
    public Vehicle changeVehicleAvailability(String refVehicle, boolean availability) {
        return null;
    }
}
