package com.loadBooking.Load.Booking.Service;

import com.loadBooking.Load.Booking.Entity.Booking;
import com.loadBooking.Load.Booking.Entity.Load;
import com.loadBooking.Load.Booking.Repository.BookingRepository;
import com.loadBooking.Load.Booking.Repository.LoadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final LoadRepository loadRepository;

    public Booking createBooking(Booking booking) {
        if (booking.getLoadId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Load ID cannot be null.");
        }

        Load load = loadRepository.findById(booking.getLoadId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Load with ID " + booking.getLoadId() + " not found. Please check the ID and try again."));

        if ("CANCELLED".equalsIgnoreCase(load.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot book a cancelled load.");
        }

        load.setStatus("BOOKED");
        loadRepository.save(load);

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        if (bookings.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No bookings found.");
        }
        return bookings;
    }

    public Booking getBookingById(UUID id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking with ID " + id + " not found. Please check the ID and try again."));
    }

    public Booking updateBooking(UUID id, Booking updatedBooking) {
        Booking existingBooking = getBookingById(id);

        if (updatedBooking.getProposedRate() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Proposed rate cannot be negative.");
        }

        if (updatedBooking.getProposedRate() != 0) {
            existingBooking.setProposedRate(updatedBooking.getProposedRate());
        }
        if (updatedBooking.getComment() != null && !updatedBooking.getComment().trim().isEmpty()) {
            existingBooking.setComment(updatedBooking.getComment());
        }
        if (updatedBooking.getStatus() != null) {
            existingBooking.setStatus(updatedBooking.getStatus());

            if ("ACCEPTED".equalsIgnoreCase(updatedBooking.getStatus())) {
                Load load = loadRepository.findById(existingBooking.getLoadId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Load not found. Please check the Load ID."));
                load.setStatus("BOOKED");
                loadRepository.save(load);
            }
        }
        return bookingRepository.save(existingBooking);
    }

    public String deleteBooking(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking with ID " + id + " not found. Please check the ID and try again."));

        Load load = loadRepository.findById(booking.getLoadId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Load with ID " + booking.getLoadId() + " not found. Please check the ID."));

        load.setStatus("AVAILABLE");
        loadRepository.save(load);

        bookingRepository.deleteById(id);

        return "Booking with ID " + id + " has been successfully deleted.";
    }
}