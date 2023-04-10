package com.wikiblaz.aeroplanner.repository;

import com.wikiblaz.aeroplanner.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}