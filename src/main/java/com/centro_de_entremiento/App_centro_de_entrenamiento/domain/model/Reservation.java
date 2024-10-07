package com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model;

import jakarta.persistence.Entity;
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

    private Long id;
    private LocalDateTime date;
    private Classes classes;
    private User user;
}
