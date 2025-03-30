package com.loadBooking.Load.Booking.Controller;


import com.loadBooking.Load.Booking.Entity.Load;
import com.loadBooking.Load.Booking.Service.LoadService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
@AllArgsConstructor
class LoadController {
    private final LoadService loadService;

    @PostMapping("/createLoad")
    public Load createLoad(@Valid @RequestBody Load load) {
        return loadService.createLoad(load);
    }
    @GetMapping("/getAllLoad")
    public List<Load> getLoads() {
        return loadService.getLoads();
    }
    @GetMapping("/{loadId}")
    public Load getLoad(@PathVariable UUID loadId) {
        return loadService.getLoadById(loadId);
    }
    @PutMapping("/{loadId}")
    public Load updateLoad(@PathVariable UUID loadId, @RequestBody Load updatedLoad) {
        return loadService.updateLoad(loadId, updatedLoad);
    }
    @DeleteMapping("/{loadId}")
    public void deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
    }
}
