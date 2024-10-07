package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.config.audits;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration
@EnableJpaAuditing // Habilita la auditoría en la aplicación
public class AuditingConfig {
}