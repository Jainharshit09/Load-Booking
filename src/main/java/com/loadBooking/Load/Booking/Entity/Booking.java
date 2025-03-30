package com.loadBooking.Load.Booking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID loadId;
    private String transporterId;
    private double proposedRate;
    private String comment;
    private String status = "PENDING";
    private Instant requestedAt = Instant.now();
}
