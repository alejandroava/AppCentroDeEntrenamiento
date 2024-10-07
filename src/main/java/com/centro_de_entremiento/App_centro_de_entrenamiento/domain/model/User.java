package com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model;

import com.centro_de_entremiento.App_centro_de_entrenamiento.utils.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Gym> gymsAdmin;

    @ManyToOne
    @JoinColumn(name = "id_gym")
    private Gym gym;

    @OneToMany(mappedBy = "user")
    private Set<ClientGym> clientGyms;

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;

}
