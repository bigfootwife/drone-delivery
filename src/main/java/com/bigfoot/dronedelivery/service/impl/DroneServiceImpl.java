package com.bigfoot.dronedelivery.service.impl;

import com.bigfoot.dronedelivery.entity.Drone;
import com.bigfoot.dronedelivery.entity.DroneState;
import com.bigfoot.dronedelivery.entity.Medication;
import com.bigfoot.dronedelivery.repository.DroneRepository;
import com.bigfoot.dronedelivery.repository.MedicationRepository;
import com.bigfoot.dronedelivery.service.DroneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;

    public DroneServiceImpl(DroneRepository droneRepository, MedicationRepository medicationRepository) {
        this.droneRepository = droneRepository;
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Drone registerDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    @Override
    public Drone loadDrone(Long droneId, List<Long> medicationIds) {
        Optional<Drone> optionalDrone = droneRepository.findById(droneId);
        if (!optionalDrone.isPresent()) {
            throw new RuntimeException("Drone not found");
        }

        Drone drone = optionalDrone.get();
        if (drone.getBatteryCapacity() < 25) {
            throw new RuntimeException("Battery too low for loading");
        }

        List<Medication> medications = medicationRepository.findAllById(medicationIds);
        int totalWeight = medications.stream().mapToInt(Medication::getWeight).sum();

        if (totalWeight > drone.getWeightLimit()) {
            throw new RuntimeException("Overweight! Cannot load medications");
        }

        drone.setState(DroneState.LOADED);
        return droneRepository.save(drone);
    }

    @Override
    public List<Medication> getLoadedMedications(Long droneId) {
        return medicationRepository.findAll();
    }

    @Override
    public List<Drone> getAvailableDrones() {
        return droneRepository.findByState(DroneState.IDLE);
    }

    @Override
    public Drone getDroneBatteryStatus(Long droneId) {
        return droneRepository.findById(droneId)
                .orElseThrow(() -> new RuntimeException("Drone not found"));
    }
}
