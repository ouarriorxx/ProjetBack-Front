package com.example.demo_ferme_plant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
    @Entity
    @Table(name = "ferme")
    public class Ferme {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "libelle")
        private String libelle;

        @Lob
        @Column(name = "image_ferme", columnDefinition = "BLOB")
        private byte[] image_ferme;
        @ManyToOne
        @JoinColumn(name = "user_id") // Crée une colonne user_id dans la table ferme pour la clé étrangère
        @JsonIgnore
        private User proprietaire; // Relation ManyToOne avec l'utilisateur qui possède la ferme

        @OneToMany(mappedBy = "ferme", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
        private List<Parcelle> parcelles;

}
