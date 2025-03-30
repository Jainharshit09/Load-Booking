package com.loadBooking.Load.Booking.Service;

import com.loadBooking.Load.Booking.Entity.Load;
import com.loadBooking.Load.Booking.Repository.LoadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LoadService {
    private final LoadRepository loadRepository;

    public Load createLoad(Load load) {
        if (load == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Load data cannot be null.");
        }
        return loadRepository.save(load);
    }

    public List<Load> getLoads() {
        List<Load> loads = loadRepository.findAll();
        if (loads.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No loads found.");
        }
        return loads;
    }

    public Load getLoadById(UUID id) {
        return loadRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Load with ID " + id + " not found. Please check the ID and try again."));
    }

    public Load updateLoad(UUID id, Load updatedLoad) {
        Load existingLoad = getLoadById(id);

        if (updatedLoad.getShipperId() != null) {
            existingLoad.setShipperId(updatedLoad.getShipperId());
        }
        if (updatedLoad.getFacility() != null) {
            existingLoad.setFacility(updatedLoad.getFacility());
        }
        if (updatedLoad.getProductType() != null) {
            existingLoad.setProductType(updatedLoad.getProductType());
        }
        if (updatedLoad.getTruckType() != null) {
            existingLoad.setTruckType(updatedLoad.getTruckType());
        }
        if (updatedLoad.getNoOfTrucks() > 0) {
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
        }
        if (updatedLoad.getWeight() > 0) {
            existingLoad.setWeight(updatedLoad.getWeight());
        }
        if (updatedLoad.getComment() != null) {
            existingLoad.setComment(updatedLoad.getComment());
        }
        return loadRepository.save(existingLoad);
    }

    public void deleteLoad(UUID id) {
        if (!loadRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Load with ID " + id + " not found. Please check the ID.");
        }
        loadRepository.deleteById(id);
    }
}
