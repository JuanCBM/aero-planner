package com.wikiblaz.aeroplanner.service;


import com.wikiblaz.aeroplanner.domain.Airport;
import com.wikiblaz.aeroplanner.domain.Flight;
import com.wikiblaz.aeroplanner.domain.Plane;
import com.wikiblaz.aeroplanner.repository.AirportRepository;
import com.wikiblaz.aeroplanner.repository.FlightRepository;
import com.wikiblaz.aeroplanner.repository.PlaneRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DatabaseLoader {
    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;
    private final PlaneRepository planeRepository;
    private final DateTimeFormatter formatter;

    public DatabaseLoader(AirportRepository airportRepository, FlightRepository flightRepository, PlaneRepository planeRepository) {
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
        this.planeRepository = planeRepository;

        this.formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }

    @PostConstruct
    private void dataInitializer() throws ParseException {

        Airport airport1 = Airport.builder()
                .codeIATA("IA1")
                .name("Barajas")
                .city("Madrid")
                .country("España")
                .build();

        Airport airport2 = Airport.builder()
                .codeIATA("IA2")
                .name("Villanubla")
                .city("Valladolid")
                .country("España")
                .build();

        Airport airport3 = Airport.builder()
                .codeIATA("IA3")
                .name("Gatwick")
                .city("Londres")
                .country("Inglaterra")
                .build();

        Plane plane1 = Plane.builder()
                .registration("N1000A1")
                .manufacturer("Boeing")
                .model("747")
                .flightHours(250.24)
                .build();

        Plane plane2 = Plane.builder()
                .registration("N1000A2")
                .manufacturer("Airbus")
                .model("350")
                .flightHours(12.87)
                .build();

        Plane plane3 = Plane.builder()
                .registration("N1000A3")
                .manufacturer("Boeing")
                .model("777")
                .flightHours(9530.61)
                .build();

        airportRepository.saveAll(Arrays.asList(airport1, airport2, airport3));
        planeRepository.saveAll(Arrays.asList(plane1, plane2, plane3));

        Flight flight1 = Flight.builder()
                .code("BA24001")
                .departureDate(LocalDateTime.parse("2020/11/09 18:12:25", formatter))
                .duration(12.45)
                .plane(plane1)
                .origin(airport3)
                .destination(airport1)
                .build();

        Flight flight2 = Flight.builder()
                .code("BA24002")
                .departureDate(LocalDateTime.parse("2021/01/10 10:12:25", formatter))
                .duration(3.15)
                .plane(plane2)
                .origin(airport3)
                .destination(airport2)
                .build();

        Flight flight3 = Flight.builder()
                .code("BA24003")
                .departureDate(LocalDateTime.parse("2020/11/10 20:15:55", formatter))
                .duration(1.15)
                .plane(plane3)
                .origin(airport2)
                .destination(airport1)
                .build();

        Flight flight4 = Flight.builder()
                .code("BA24004")
                .departureDate(LocalDateTime.parse("2020/11/10 00:12:01", formatter))
                .duration(5.97)
                .plane(plane1)
                .origin(airport3)
                .destination(airport1)
                .build();

        Flight flight5 = Flight.builder()
                .code("BA24005")
                .departureDate(LocalDateTime.parse("2020/11/10 23:00:00", formatter))
                .duration(5.97)
                .plane(plane1)
                .origin(airport3)
                .destination(airport1)
                .build();

        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3, flight4, flight5));

    }
}
