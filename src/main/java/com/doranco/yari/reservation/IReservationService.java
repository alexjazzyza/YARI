package com.doranco.yari.reservation;

import com.doranco.yari.vehicle.Vehicle;

import java.util.List;

public interface IReservationService {
    public Reservation saveReservation(Reservation reservation) throws Exception;
    public Reservation updateResevation(Reservation reservation) throws Exception;
    public Reservation removeReservation(String idResevation) throws Exception;
    public  double calculationAmount(Vehicle vehicle) throws Exception;
;


    List<Reservation> getAllReservation() throws Exception;
}
