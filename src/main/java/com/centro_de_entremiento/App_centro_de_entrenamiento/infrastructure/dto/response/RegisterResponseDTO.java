package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.response;

import com.centro_de_entremiento.App_centro_de_entrenamiento.utils.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RegisterResponseDTO {

    private String message;

    private Role role;

}
