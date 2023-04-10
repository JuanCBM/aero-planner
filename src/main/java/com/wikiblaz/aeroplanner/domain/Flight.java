package com.wikiblaz.aeroplanner.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime departureDate;

    private Double duration;

    @JsonIgnore
    @ManyToOne
    private Plane plane;

    @JsonIgnore
    @ManyToOne
    private Airport destination;

    @JsonIgnore
    @ManyToOne
    private Airport origin;

    @JsonProperty("plane")
    public Plane getPlane() {
        return plane;
    }

    @JsonProperty("destination")
    public Airport getDestination() {
        return destination;
    }

    @JsonProperty("origin")
    public Airport getOrigin() {
        return origin;
    }

    @JsonProperty("idPlane")
    public void setIdPlane(Long idPlane) {
        if (idPlane != null) {
            this.plane = Plane.of(idPlane);
        } else {
            this.plane = null;
        }
    }

    @JsonProperty("idDestination")
    public void setIdDestination(Long idDestination) {
        if (idDestination != null) {
            this.destination = Airport.of(idDestination);
        } else {
            this.destination = null;
        }
    }

    @JsonProperty("idOrigin")
    public void setIdOrigin(Long idOrigin) {
        if (idOrigin != null) {
            this.origin = Airport.of(idOrigin);
        } else {
            this.origin = null;
        }
    }


}