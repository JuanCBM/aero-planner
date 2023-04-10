package com.wikiblaz.aeroplanner.service;

import com.wikiblaz.aeroplanner.domain.Plane;
import com.wikiblaz.aeroplanner.repository.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PlaneService {
    private final PlaneRepository planeRepository;

    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public Collection<Plane> findAll() {
        return this.planeRepository.findAll();
    }

    public Optional<Plane> getPlane(long id) {
        return this.planeRepository.findById(id);
    }

    public void save(Plane plane) {
        this.planeRepository.save(plane);
    }
}