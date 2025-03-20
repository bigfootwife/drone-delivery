package com.bigfoot.dronedelivery.controller;

import com.bigfoot.dronedelivery.entity.Drone;
import com.bigfoot.dronedelivery.entity.Medication;
import com.bigfoot.dronedelivery.service.DroneService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping("/register")
    public ResponseEntity<Drone> registerDrone(@Valid @RequestBody Drone drone) {
        Drone savedDrone = droneService.registerDrone(drone);
        return ResponseEntity.ok(savedDrone);
    }

    @PostMapping("/{droneId}/load")
    public Drone loadDrone(@PathVariable Long droneId, @RequestBody List<Long> medicationIds) {
        return droneService.loadDrone(droneId, medicationIds);
    }

    @GetMapping("/{droneId}/medications")
    public List<Medication> getLoadedMedications(@PathVariable Long droneId) {
        return droneService.getLoadedMedications(droneId);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Drone>> getAvailableDrones() {
        List<Drone> availableDrones = droneService.getAvailableDrones();
        return ResponseEntity.ok(availableDrones);
    }

    @GetMapping("/{droneId}/battery")
    public ResponseEntity<Drone> getBatteryStatus(@PathVariable Long droneId) {
        Drone drone = droneService.getDroneBatteryStatus(droneId);
        return ResponseEntity.ok(drone);
    }
}
