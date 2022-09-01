package com.doranco.yari.agency;

import com.doranco.yari.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyService implements IAgencyService{

    private final AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public Page<Agency> getAllAgencies(Pageable pageable) {
        return agencyRepository.findAll(pageable);
    }

    @Override
    public Agency saveAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    @Override
    public Agency updateAgency(Agency agency) throws Exception {
        return agencyRepository.save(agency);
    }

    @Override
    public Agency deleteAgency(Long idAgency) throws Exception {
        Agency agency = getAgencyById(idAgency);
        agencyRepository.deleteById(idAgency);
        return agency;
    }

    @Override
    public Agency getAgencyById(Long idAgency) {
        Optional<Agency> agencyOptional = agencyRepository.findById(idAgency);
        if (agencyOptional.isPresent())
        {
            return agencyOptional.get();
        }
        else
        {
            throw new RuntimeException("Agency not found.");
        }
    }
}
