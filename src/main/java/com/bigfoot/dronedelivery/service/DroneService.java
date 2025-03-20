package com.bigfoot.dronedelivery.service;

import com.bigfoot.dronedelivery.entity.Drone;
import com.bigfoot.dronedelivery.entity.Medication;

import java.util.List;

public interface DroneService {
    Drone registerDrone(Drone drone);
    Drone loadDrone(Long droneId, List<Long> medicationIds);
    List<Medication> getLoadedMedications(Long droneId);
    List<Drone> getAvailableDrones();
    Drone getDroneBatteryStatus(Long droneId);
}
