package com.loadBooking.Load.Booking.Controller;


import com.loadBooking.Load.Booking.Entity.Booking;
import com.loadBooking.Load.Booking.Service.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
class BookingController {
    private final BookingService bookingService;

    @PostMapping("/createBooking")
    public Booking createBooking(@Valid @RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
    @GetMapping("/getAllBooking")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }
    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable UUID bookingId) {
        return bookingService.getBookingById(bookingId);
    }
    @PutMapping("/{bookingId}")
    public Booking updateBooking(@PathVariable UUID bookingId, @RequestBody Booking updatedBooking) {
        return bookingService.updateBooking(bookingId, updatedBooking);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable UUID id) {
        String response = bookingService.deleteBooking(id);
        return ResponseEntity.ok(response);
    }

}