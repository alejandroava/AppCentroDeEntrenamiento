package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.config.openai;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(

        info = @Info(
                title = "Centro de entrenamientos",
                description = "endpoint de admin.client,trainer",
                version = "A1"
        ),
        security = {
                @SecurityRequirement(name = "jwt")
        }
)
@SecurityScheme(name = "jwt",description = "seguridad con jwt",type = SecuritySchemeType.HTTP,bearerFormat = "JWT",scheme = "bearer",in = SecuritySchemeIn.HEADER)
public class SwaggerConfiguration {

}
