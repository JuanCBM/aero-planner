package com.wikiblaz.aeroplanner.service;

import com.wikiblaz.aeroplanner.domain.Airport;
import com.wikiblaz.aeroplanner.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Collection<Airport> findAll() {
        return this.airportRepository.findAll();
    }

    public Optional<Airport> getAirport(long id) {
        return this.airportRepository.findById(id);
    }

    public void save(Airport airport) {
        this.airportRepository.save(airport);
    }
}
