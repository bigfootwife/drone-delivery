package com.bigfoot.dronedelivery.repository;

import com.bigfoot.dronedelivery.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
