package com.doranco.yari.reservation;

public interface IReservationService {
    public Reservation save(Reservation reservation) throws Exception;
    public Reservation updateResevation(Reservation reservation) throws Exception;
    public Reservation removeReservation(String idResevation) throws Exception;
    
}
