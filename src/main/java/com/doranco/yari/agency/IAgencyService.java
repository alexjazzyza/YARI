package com.doranco.yari.agency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAgencyService {

    public Page<Agency> getAllAgencies(Pageable pageable);
    public Agency saveAgency(Agency agency);
    public Agency updateAgency(Agency agency) throws Exception;
    public Agency deleteAgency(Long idAgency) throws Exception;
    public Agency getAgencyById(Long idAgency) throws Exception;
    public Agency getAgencyByName(String agencyName) throws Exception;
    public List<Agency> getAgenciesByCity(ECities city) throws Exception;
}
