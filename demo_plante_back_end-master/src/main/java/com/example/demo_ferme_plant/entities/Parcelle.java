package com.example.demo_ferme_plant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "parcelle")
public class Parcelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Lob
    @Column(name = "image_parcelle", columnDefinition = "BLOB")
    private byte[] image_parcelle ;

    @ManyToOne
    @JoinColumn(name = "ferme_id")
    @JsonIgnore
    private Ferme ferme;

    @OneToMany(mappedBy = "parcelle", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Plantage> plantages = new ArrayList<>();

}