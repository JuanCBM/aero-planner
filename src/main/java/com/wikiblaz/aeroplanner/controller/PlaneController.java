package com.wikiblaz.aeroplanner.controller;

import com.wikiblaz.aeroplanner.domain.Plane;
import com.wikiblaz.aeroplanner.service.PlaneService;
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
@RequestMapping(path = "${services.url.prefix}/planes")
public class PlaneController {
    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Collection<Plane>> list() {
        return ResponseEntity.ok(planeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlane(@PathVariable long id) {
        Optional<Plane> plane = planeService.getPlane(id);
        if (plane.isPresent()) {
            return ResponseEntity.ok(plane.get());
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        this.planeService.save(plane);
        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(plane.getId()).toUri();

        return ResponseEntity.created(location).body(plane);
    }

}