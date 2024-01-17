package com.example.demo_ferme_plant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Type_plante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String temperature;
    private int humidite_max;
    private int humidite_min;

    @OneToMany(mappedBy = "type_plante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Plante> plantes;
}
