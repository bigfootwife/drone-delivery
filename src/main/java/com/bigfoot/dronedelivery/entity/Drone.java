package com.bigfoot.dronedelivery.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("serial_number")
    @Column(unique=true, length=100, nullable = false)
    private String serialNumber;

    @JsonProperty("model")
    @Enumerated(EnumType.STRING)
    private DroneModel model;

    @JsonProperty("weight_limit")
    private int weightLimit; // in grams

    @JsonProperty("battery_capacity")
    private int batteryCapacity; // percentage

    @JsonProperty("state")
    @Enumerated(EnumType.STRING)
    private DroneState state;

    public int getWeightLimit() {
        return weightLimit;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setState(DroneState state) {
        this.state = state;
    }
}
