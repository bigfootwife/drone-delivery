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
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    @Column(nullable = false, unique = true)
    private String name;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("code")
    @Column(nullable = false, unique = true)
    private String code;

    @JsonProperty("imageUrl")
    private String imageUrl; // Store image as a URL/path

    public int getWeight() {
        return weight;
    }
}
