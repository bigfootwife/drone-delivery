package com.bigfoot.dronedelivery.repository;

import com.bigfoot.dronedelivery.entity.Drone;
import com.bigfoot.dronedelivery.entity.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneRepository extends JpaRepository <Drone, Long>{
    List<Drone> findByState(DroneState state);
    List<Drone> findByBatteryCapacityGreaterThanEqual(int batteryLevel);
}
