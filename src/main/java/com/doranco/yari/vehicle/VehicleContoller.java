package com.doranco.yari.vehicle;

/*@Controller
@RequestMapping("/")*/
public class VehicleContoller {

    private final IVehicleService vehicleService;

    public VehicleContoller(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
   /* @GetMapping
    public String getProductsPage(    ){



        return "chaine";
    }*/
}
