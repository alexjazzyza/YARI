package com.doranco.yari.reservation;

import com.doranco.yari.Utilities.DateConversion;
import com.doranco.yari.agency.Agency;
import com.doranco.yari.agency.ECities;
import com.doranco.yari.agency.IAgencyService;
import com.doranco.yari.authentication.IApplicationUserService;
import com.doranco.yari.user.IUserService;
import com.doranco.yari.user.customer.Customer;
import com.doranco.yari.user.customer.ICustomerService;
import com.doranco.yari.vehicle.EVehicleType;
import com.doranco.yari.vehicle.IVehicleService;
import com.doranco.yari.vehicle.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {

    private final IReservationService reservationService;
    private final IVehicleService vehicleService;
    private final IAgencyService agencyService;
    private final IUserService userService;
    private final ICustomerService customerService;
    private final IApplicationUserService applicationUserService;

    public ReservationController(IReservationService reservationService, IVehicleService vehicleService, IAgencyService agencyService, IUserService userService, ICustomerService customerService, IApplicationUserService applicationUserService1) {
        this.reservationService = reservationService;
        this.vehicleService = vehicleService;
        this.agencyService = agencyService;
        this.userService = userService;
        this.customerService = customerService;
        this.applicationUserService = applicationUserService1;
    }
    @GetMapping(path = "/index")
    public String addReservation(Model model){
        return "index";
    }

    @PostMapping(path = "/searchVehicles")
    public String searchVehicle(@RequestParam(name="city") String cityString,
                                @RequestParam(name="vehicleType") String vehicleTypeString,
                                @RequestParam(name="startDate") String startDateString,
                                @RequestParam(name="endDate") String endDateString,
                                Model model){

        ECities city = ECities.valueOf(cityString);
        EVehicleType vehicleType = EVehicleType.valueOf(vehicleTypeString);
        Date startDate;
        Date endDate;

        startDate = DateConversion.convertDateA(startDateString);
        endDate = DateConversion.convertDateA(endDateString);

        try {
            List<Vehicle> availableVehicle = vehicleService.getAvailableVehicle(city, new SimpleDateFormat("yyyy-MM-dd").parse(startDateString), new SimpleDateFormat("yyyy-MM-dd").parse(endDateString), vehicleType);
            model.addAttribute("availableVehicles", availableVehicle);
            model.addAttribute("city", city);
            model.addAttribute("startDate", startDateString);
            model.addAttribute("endDate", endDateString);
            return "search_vehicles";
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @PostMapping(path = "/saveReservation")
    public String saveReservation(@RequestParam(name="refVehicle") Long refVehicle,
                                  @RequestParam(name="city") String cityString,
                                  @RequestParam(name="startDate") String startDateString,
                                  @RequestParam(name="endDate") String endDateString,
                                  Model model) {

        List<Agency> agencies = null;
        Agency agency = null;
        try {
            agencies = agencyService.getAgenciesByCity(ECities.valueOf(cityString));
            agency = agencies.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Vehicle vehicle = null;
        try {
            vehicle = vehicleService.getVehicleById(refVehicle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Date startDate;
        Date endDate;

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            startDate = formatter.parse(startDateString);
            endDate = formatter.parse(endDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String username = applicationUserService.getUsername();
        Long userId = userService.getUserByUsername(username).getIdUser();

        try {
            Customer customer = customerService.getCustomerById(userId);
            Reservation reservation = reservationService.makeReservation(startDate, endDate, agency, vehicle, customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "/index";
    }

    @GetMapping("/reservations")
    public String getReservations(Model model) {

        String username = applicationUserService.getUsername();
        Long userId = userService.getUserByUsername(username).getIdUser();

        List<Reservation> reservations = null;

        try {
            reservations = reservationService.getReservationsByCustomerId(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("reservations", reservations);

        return "reservations";
    }

    @GetMapping("/reservationDetails")
    public String reservationDetails(@RequestParam(name = "reservation") Reservation reservation,
                                     BindingResult bindingResult,
                                     Model model) {

        model.addAttribute("reservation", reservation);

        return "reservation_details";
    }
}

