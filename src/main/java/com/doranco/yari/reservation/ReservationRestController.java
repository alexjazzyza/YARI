package com.doranco.yari.reservation;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {
    private final IReservationService reservationService;
    public ReservationRestController(IReservationService ReservationService) {
        this.reservationService = ReservationService;
    }

    @GetMapping
    public List<Reservation> getListReservations(){

        try {
            return reservationService.getAllReservations();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public  Reservation saveReservations(@RequestBody Reservation reservation){
       Reservation res = null;
        try {
            res= reservationService.saveReservation(reservation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @PutMapping("/{idReservation}")
    public Reservation updateReservation(@PathVariable Long idReservation, @RequestBody Reservation reservation) {
        Reservation res = null;
        try {
            res = reservationService.updateReservation(reservation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @DeleteMapping("/{idReservation}")
    public Reservation deleteReservation(@PathVariable Long idReservation) {
        Reservation res = null;
        try {
            res = reservationService.deleteReservation(idReservation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
