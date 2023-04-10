package com.wikiblaz.aeroplanner.repository;

import com.wikiblaz.aeroplanner.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}