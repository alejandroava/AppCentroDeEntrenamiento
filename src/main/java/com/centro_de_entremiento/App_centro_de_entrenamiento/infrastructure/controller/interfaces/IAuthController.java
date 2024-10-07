package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.controller.interfaces;

import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request.LoginRequestDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request.RegisterRequestDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.response.RegisterResponseDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.utils.Role;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAuthController {
    ResponseEntity<?> login(LoginRequestDTO loginRequestDTO);
    ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO,
                                      @RequestParam(required = false, defaultValue = "USER") Role role);
}
