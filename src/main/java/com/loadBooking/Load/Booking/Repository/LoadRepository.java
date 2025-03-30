package com.loadBooking.Load.Booking.Repository;

import com.loadBooking.Load.Booking.Entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
    List<Load> findByShipperId(String shipperId);
    List<Load> findByTruckType(String truckType);
}