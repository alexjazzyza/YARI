package com.doranco.yari.reservation;

import com.doranco.yari.agency.AgencyService;
import com.doranco.yari.agency.ECities;
import com.doranco.yari.vehicle.EVehicleType;
import com.doranco.yari.vehicle.IVehicleService;
import com.doranco.yari.vehicle.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {

    private final IReservationService Irs;
    private final IVehicleService vehicleService;

    private final AgencyService agencyService;

    public ReservationController(IReservationService irs, IVehicleService vehicleService, AgencyService agencyService) {
        this.Irs = irs;
        this.vehicleService = vehicleService;
        this.agencyService = agencyService;
    }
    @GetMapping(path = "/index")
    public String addReservation(Model model){
        model.addAttribute("reservation",new Reservation());
        return "index";
    }

    @PostMapping(path = "/searchVehicles")
    public String searchVehicle(@Valid Reservation reservation, BindingResult result, Model model, @RequestParam(name="city") String cityString, @RequestParam(name="vehicleType") String vehicleTypeString){
        if(result.hasErrors()) return "index" ;
        ECities city = ECities.valueOf(cityString);
        Date startDate = reservation.getStartDate();
        Date endDate = reservation.getEndDate();
        EVehicleType vehicleType = EVehicleType.valueOf(vehicleTypeString);
        try {
            List<Vehicle> availableVehicle = vehicleService.getAvailableVehicle(city, startDate, endDate, vehicleType);
            model.addAttribute("availableVehicles", availableVehicle);

            model.addAttribute("vehicle", new Vehicle());

            reservation.getAgency().setCity(city);
            model.addAttribute("reservation", reservation);
            return "searchVehicles";
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @PostMapping(path = "/saveReservation")
    public String saveReservation(@Valid Reservation reservation, @Valid Vehicle vehicle, BindingResult result, Model model) {

        System.out.println("test");
        return "/index";
    }
}

