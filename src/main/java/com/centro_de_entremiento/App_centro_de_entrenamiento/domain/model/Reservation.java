package com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classes classes;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
