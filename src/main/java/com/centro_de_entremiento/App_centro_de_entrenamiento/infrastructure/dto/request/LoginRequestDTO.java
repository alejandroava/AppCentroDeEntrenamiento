package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginRequestDTO {

    @NotBlank(message = "required email")
    private String email;
    @NotBlank(message = "required password")
    private String password;
}
