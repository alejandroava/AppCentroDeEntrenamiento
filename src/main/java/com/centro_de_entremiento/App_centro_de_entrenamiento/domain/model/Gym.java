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
@Entity(name = "gyms")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_userAdmin")
    private User user;
    @OneToMany(mappedBy = "gym")
    private Set<User> userTrainer;

    @OneToMany(mappedBy = "gym")
    private Set<ClientGym> clientGyms;

    @OneToMany(mappedBy = "gym")
    private Set<GymClass> gymClasses;
}
