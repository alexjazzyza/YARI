package com.doranco.yari.reservation;

import com.doranco.yari.vehicle.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService{
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) throws Exception {

        return reservationRepository.save(reservation);
    }
    public boolean isAVailable (){
        //tester les dates entrées par le custoemrs avec les dates de
        //


        return true;
    }

    @Override
    public Reservation updateResevation(Reservation reservation) throws Exception {
        return  reservationRepository.save(reservation);
    }

    @Override
    public Reservation removeReservation(String idResevation) throws Exception {
        Reservation reservation = getReservationById(idResevation);
        reservationRepository.deleteById(idResevation);
        return reservation;

    }
    public Reservation getReservationById(String idReservation) throws Exception {
        Optional<Reservation> reservationOptional = reservationRepository.findById(idReservation);
        if (reservationOptional.isPresent())
        {
            return reservationOptional.get();
        }
        else
            throw new RuntimeException("Resevation not found.");
    }

    @Override
    public double calculationAmount(Vehicle vehicle) throws Exception {

        float coeffVehicule = vehicle.getPriceCoeff();
       return coeffVehicule * 100;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }
}
