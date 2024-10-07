package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request;

import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.ClientGym;
import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.Gym;
import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.Reservation;
import com.centro_de_entremiento.App_centro_de_entrenamiento.utils.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Builder
public class RegisterRequestDTO {

    @NotBlank(message = "required username")
    private String username;
    @NotBlank(message = "required email")
    private String email;
    @NotBlank(message = "required password")
    private String password;
//    @NotBlank(message = "required role")
//    private Role role;

    private Long idGym;
}
