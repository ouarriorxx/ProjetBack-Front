package com.example.demo_ferme_plant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom ;
    private  String prenom ;
    private  int role;
    private  String email;

    private  String password ;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;

    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Ferme> fermes;


}
