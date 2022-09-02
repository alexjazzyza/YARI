package com.doranco.yari.reservation;

import java.util.List;

public interface IReservationService {
    public Reservation saveReservation(Reservation reservation) throws Exception;
    public Reservation updateReservation(Reservation reservation) throws Exception;
    public Reservation deleteReservation(Long idReservation) throws Exception;
    public  double calculatePrice(Long idReservation) throws Exception;
    public List<Reservation> getAllReservations() throws Exception;
    public List<Reservation> getReservationsByCustomerId(Long idCustomer) throws Exception;

}
