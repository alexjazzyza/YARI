package com.doranco.yari.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/reservations")
public class ReservationRestController {
    private final IReservationService iReservationService;
    public ReservationRestController(IReservationService iReservationService) {
        this.iReservationService = iReservationService;
    }

    @GetMapping
    public List<Reservation> getListReservations(){

        try {
            return iReservationService.getAllReservation();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public  Reservation saveReservations(@RequestBody Reservation reservation){
       Reservation res = null;
        try {
            res= iReservationService.saveReservation(reservation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
