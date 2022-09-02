package com.doranco.yari.reservation;

import com.doranco.yari.vehicle.IVehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {
    private final IReservationService reservationService;

    private final IVehicleService vehicleService;

    public ReservationRestController(IReservationService ReservationService, IVehicleService vehicleService) {
        this.reservationService = ReservationService;
        this.vehicleService = vehicleService;
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
