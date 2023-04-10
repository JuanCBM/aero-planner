package com.wikiblaz.aeroplanner.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
public class Airport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 3)
    private String codeIATA;

    private String name;

    private String city;

    private String country;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origin")
    List<Flight> origins;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destination")
    List<Flight> destinations;

    public static Airport of(Long id) {
        return Airport.builder().id(id).build();
    }

}
