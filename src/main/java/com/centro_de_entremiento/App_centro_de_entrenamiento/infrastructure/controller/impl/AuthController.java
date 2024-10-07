package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.controller.impl;

import com.centro_de_entremiento.App_centro_de_entrenamiento.application.service.imodel.IModelAuth;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.controller.interfaces.IAuthController;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request.LoginRequestDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request.RegisterRequestDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.response.RegisterResponseDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.utils.Role;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements IAuthController {

    @Autowired
    IModelAuth authService;

    @PostMapping("/login")
    @Override
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequestDTO));
        }catch (UsernameNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO,
                                      @RequestParam(required = false, defaultValue = "USER") Role role) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO,role));
        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
