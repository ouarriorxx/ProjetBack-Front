package com.example.demo_ferme_plant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
public class Plante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String racine;
    @Column(name = "libelle")
    private String libelle;

    @Lob
    @Column(name = "image_plante", columnDefinition = "BLOB")
    private byte[] image_plante ;



    @OneToMany(mappedBy = "plante")
    @JsonIgnore
    private List<Plantage> plantages = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "type_plante_id")
    @JsonIgnore
    private Type_plante type_plante;

}
