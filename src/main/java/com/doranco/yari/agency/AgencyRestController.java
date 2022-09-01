package com.doranco.yari.agency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agencies")
public class AgencyRestController {

    private final AgencyService agencyService;

    public AgencyRestController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public Page<Agency> getAgencyPage(@RequestParam(name="size", defaultValue="10") int size,
                                      @RequestParam(name="page", defaultValue = "0") int page) {

        Page<Agency> agencies = null;

        try {
            agencies = agencyService.getAllAgencies(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException("No Agency found.");
        }

        return agencies;
    }

    @PostMapping
    public Agency save(@RequestBody Agency agency) {
        agency = agencyService.saveAgency(agency);
        return agency;
    }

    @PutMapping("/{idAgency}")
    public Agency updateAgency(@PathVariable Long idAgency, @RequestBody Agency agency){
        agency = agencyService.saveAgency(agency);
        return agency;
    }

    @DeleteMapping("/{idAgency}")
    public Agency deleteAgency(@PathVariable Long idAgency) {
        Agency agency = null;
        try {
            agency = agencyService.deleteAgency(idAgency);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return agency;
    }

    @GetMapping("/getById")
    public Agency getAgencyById(@RequestParam Long idAgency) {
        Agency agency = null;
        try {
            agency = agencyService.getAgencyById(idAgency);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return agency;
    }


}
