package com.doranco.yari.agency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAgencyService {

    public Page<Agency> getAllAgencies(Pageable pageable);
    public Agency saveAgency(Agency agency);
    public Agency updateAgency(Agency agency) throws Exception;
    public Agency deleteAgency(Long idAgency) throws Exception;
    public Agency getAgencyById(Long idAgency);
}
