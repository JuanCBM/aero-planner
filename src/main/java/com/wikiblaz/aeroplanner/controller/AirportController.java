package com.wikiblaz.aeroplanner.controller;

import com.wikiblaz.aeroplanner.domain.Airport;
import com.wikiblaz.aeroplanner.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "${services.url.prefix}/airports")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Collection<Airport>> list() {
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirport(@PathVariable long id) {
        Optional<Airport> airport = airportService.getAirport(id);
        if (airport.isPresent()) {
            return ResponseEntity.ok(airport.get());
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        this.airportService.save(airport);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(airport.getId()).toUri();

        return ResponseEntity.created(location).body(airport);
    }

}