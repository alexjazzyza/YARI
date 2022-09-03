package com.doranco.yari.agency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

    public List<Agency> findAllByCity(ECities city);
}
