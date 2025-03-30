package com.loadBooking.Load.Booking.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loads")
public class Load {
    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    private String shipperId;
    @Embedded
    private Facility facility;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private String comment;
    private Instant datePosted = Instant.now();
    private String status = "POSTED";
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class Facility {
    private String loadingPoint;
    private String unloadingPoint;
    private Instant loadingDate;
    private Instant unloadingDate;
}