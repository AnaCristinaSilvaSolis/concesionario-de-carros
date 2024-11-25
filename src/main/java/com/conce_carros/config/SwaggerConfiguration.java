package com.conce_carros.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Concesionario carros",
                description = "this is an application for a car dealership",
                version = "1.0.0",
                contact = @Contact(
                        name = "Ana Cristina Silva",
                        url = "https://www.linkedin.com/in/anacristinasilvasolis",
                        email = "cristinasilvasolis09@gmail.com"
                )
        )
)

/*@SecurityScheme(
        name = "Security Token",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP, //HTTP-> si trabajamos con tokens, DEFAULT-> no hace nada
        paramName = HttpHeaders.AUTHORIZATION, //lo mismo que usamos en postman
        in = SecuritySchemeIn.HEADER, //recordar que los tokens tambien se pueden manejar en las COOKIES
        scheme = "bearer", //lo mismo que usamos en postman
        bearerFormat = "JWT"
)*/
public class SwaggerConfiguration {
}
