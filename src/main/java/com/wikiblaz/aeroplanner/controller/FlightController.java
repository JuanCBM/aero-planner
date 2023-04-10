package com.wikiblaz.aeroplanner.controller;

import com.wikiblaz.aeroplanner.domain.Flight;
import com.wikiblaz.aeroplanner.service.FlightService;
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
@RequestMapping(path = "${services.url.prefix}/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Collection<Flight>> getFlights() {
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable long id) {
        Optional<Flight> flight = flightService.getFlight(id);
        if (flight.isPresent()) {
            return ResponseEntity.ok(flight.get());
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        this.flightService.save(flight);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(flight.getId()).toUri();

        return ResponseEntity.created(location).body(flight);
    }

}