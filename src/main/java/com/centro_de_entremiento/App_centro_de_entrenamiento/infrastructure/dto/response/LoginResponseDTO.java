package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.response;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginResponseDTO {

    private String message;

    private String token;
}
