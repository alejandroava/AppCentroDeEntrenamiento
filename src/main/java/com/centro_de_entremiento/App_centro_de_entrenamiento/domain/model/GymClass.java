package com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "gym_class")
public class GymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_gym")
    private Gym gym;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes classes;
}
