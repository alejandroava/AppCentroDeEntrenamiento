package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.config.audits;


import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Obtener el contexto de seguridad actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificar si hay un usuario autenticado
        if (authentication != null && authentication.isAuthenticated()) {
            // Retornar el nombre del usuario autenticado
            return Optional.of(authentication.getName()); // o puedes usar authentication.getPrincipal() para obtener más detalles
        }
        // Si no hay usuario autenticado, retornar un valor por defecto o vacío
        return Optional.of("ADMIN"); // o Optional.of("defaultUser") si deseas un valor por defecto
    }
}