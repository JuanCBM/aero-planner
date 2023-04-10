package com.wikiblaz.aeroplanner.service;

import com.wikiblaz.aeroplanner.domain.Flight;
import com.wikiblaz.aeroplanner.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Collection<Flight> findAll() {
        return this.flightRepository.findAll();
    }

    public Optional<Flight> getFlight(long id) {
        return this.flightRepository.findById(id);
    }

    public void save(Flight flight) {
        this.flightRepository.save(flight);
    }
}
