package com.exam_service.Exam_Service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {

        final String securitySchemeName = "Bearer Authentication";

        return new OpenAPI()

                .info(
                        new Info()
                                .title("Online Examination Platform - Exam Service")
                                .description("REST APIs for Exam Service")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Abhish Tarhekar")

                                )
                )

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(securitySchemeName)
                )

                .schemaRequirement(
                        securitySchemeName,

                        new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                );
    }
}
