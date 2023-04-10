package com.wikiblaz.aeroplanner.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Plane {

    @Id
    @GeneratedValue
    private Long id;

    private String registration;

    private String manufacturer;

    private String model;

    private Double flightHours;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plane")
    List<Flight> flights;

    public static Plane of(Long id) {
        return Plane.builder().id(id).build();
    }
}
