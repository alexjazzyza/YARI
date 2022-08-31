package com.doranco.yari.vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleRestController {

    private final IVehicleService vehicleService;

    public VehicleRestController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public Page<Vehicle> getVehiclesPage (@RequestParam(name="size", defaultValue="10") int size,
                                         @RequestParam(name="page", defaultValue = "0") int page) {

        Page<Vehicle> vehicles = null;

        try{
            vehicles = vehicleService.getAllVehicles(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    @PostMapping
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {

        Vehicle v = null;
        try {
            v = vehicleService.saveVehicle(vehicle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return v;
    }

    @PutMapping("/{refVehicle}")
    public Vehicle updateVehicle(@PathVariable String refVehicle, @RequestBody Vehicle vehicle) {

        Vehicle v = null;
        try {
            v = vehicleService.updateVehicle(vehicle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return v;
    }

    @DeleteMapping("/{refVehicle}")
    public Vehicle deleteVehicle(@PathVariable String refVehicle) {

        Vehicle v = null;
        try {
            v = vehicleService.deleteVehicle(refVehicle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return v;
    }

    @GetMapping("/getById")
    public Vehicle getVehicleById(@RequestParam(name="refVehicle") String refVehicle)
    {
        Vehicle v = null;
        try {
            v = vehicleService.getVehicleById(refVehicle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return v;
    }
}
