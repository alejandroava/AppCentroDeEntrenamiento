package com.centro_de_entremiento.App_centro_de_entrenamiento.domain.persistence;

import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
