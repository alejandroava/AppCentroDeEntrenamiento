package com.centro_de_entremiento.App_centro_de_entrenamiento.domain.persistence;

import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym,Long> {
}
