package com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer capacity;
    @OneToMany(mappedBy = "classes")
    private Set<Reservation> reservations;
    @OneToMany(mappedBy = "classes")
    private Set<GymClass> gymClasses;

}
