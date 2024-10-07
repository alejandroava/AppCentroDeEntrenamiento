package com.centro_de_entremiento.App_centro_de_entrenamiento.application.service.imodel;

import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request.LoginRequestDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request.RegisterRequestDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.response.LoginResponseDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.response.RegisterResponseDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.utils.Role;

public interface IModelAuth {

    LoginResponseDTO login (LoginRequestDTO loginRequestDTO);

    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO, Role role);
}
