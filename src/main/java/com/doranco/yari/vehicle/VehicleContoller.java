package com.doranco.yari.vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class VehicleContoller {

    private final IVehicleService iVS;

    public VehicleContoller(IVehicleService iVS) {
        this.iVS = iVS;
    }
    @GetMapping
    public String getProductsPage(    ){



        return "chaine";
    }
}
