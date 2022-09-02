package com.doranco.yari.reservation;

import com.doranco.yari.agency.ECities;
import com.doranco.yari.vehicle.EVehicleType;
import com.doranco.yari.vehicle.Vehicle;
import com.doranco.yari.vehicle.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) throws Exception {

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) throws Exception {
        return  reservationRepository.save(reservation);
    }

    @Override
    public Reservation deleteReservation(Long idReservation) throws Exception {
        Reservation reservation = getReservationById(idReservation);
        reservationRepository.deleteById(idReservation);
        return reservation;

    }
    public Reservation getReservationById(Long idReservation) throws Exception {
        Optional<Reservation> reservationOptional = reservationRepository.findById(idReservation);
        if (reservationOptional.isPresent())
        {
            return reservationOptional.get();
        }
        else
            throw new RuntimeException("Reservation not found.");
    }

    @Override
    public double calculatePrice(Long idReservation) throws Exception {

        float coeffVehicule = getReservationById(idReservation).getVehicle().getPriceCoeff();
       return coeffVehicule * 100;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByCustomerId(Long idCustomer) throws Exception {

        List<Reservation> reservations = null;

        reservations = reservationRepository.findAllByCustomerIdUser(idCustomer);

        return reservations;
    }
}
