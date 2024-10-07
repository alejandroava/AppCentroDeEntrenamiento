package com.centro_de_entremiento.App_centro_de_entrenamiento.application.service.impl;

import com.centro_de_entremiento.App_centro_de_entrenamiento.application.service.imodel.IModelAuth;
import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.Gym;
import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.User;
import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.persistence.GymRepository;
import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.persistence.UserRepository;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request.LoginRequestDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.request.RegisterRequestDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.response.LoginResponseDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.dto.response.RegisterResponseDTO;
import com.centro_de_entremiento.App_centro_de_entrenamiento.utils.Role;
import com.centro_de_entremiento.App_centro_de_entrenamiento.utils.helpers.JWTService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IModelAuth {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    GymRepository gymRepository;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        User user = userRepository.findByEmail(loginRequestDTO.getEmail());

        if(user == null ){
            throw new UsernameNotFoundException("User not found");
        }

        return  LoginResponseDTO.builder()
                .message("Login successful")
                .token(jwtService.getToken(user))
                .build();
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO, Role role) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getAuthorities()
                .stream().anyMatch(grantedAuthority -> grantedAuthority.equals(Role.CLIENT.name()) && grantedAuthority.equals(Role.TRAINER.name()))) {
            throw new IllegalArgumentException("Logged in users cannot register new accounts");
        }

        User user = userRepository.findByEmail(registerRequestDTO.getEmail());
        if(user != null){
            throw new IllegalArgumentException("user exist");
        }

        Gym gymExist = gymRepository.findById(registerRequestDTO.getIdGym()).orElse(null);


        User userSave = User.builder()
                .email(registerRequestDTO.getEmail())
                .username(registerRequestDTO.getUsername())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .role(role)
                .gym(gymExist)
                .build();

        userRepository.save(userSave);



        return RegisterResponseDTO.builder()
                .message("Register successful")
                .role(role)
                .build();
    }

}
