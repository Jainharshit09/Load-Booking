package com.loadBooking.Load.Booking.Repository;

import com.loadBooking.Load.Booking.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    List<Booking> findByTransporterId(String transporterId);
}
