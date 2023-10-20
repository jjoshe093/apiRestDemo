package com.apirest.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .info(new Info()
                        .title("Api Rest Demo")
                        .version("1.0")
                        .description("Versión demo de una api rest que expone endpoints para administración de libros")
                        .termsOfService("https://www.google.com.sv")
                        .license(new License().name("OPEN").url("https://www.google.com.sv"))
                        .contact(new Contact().name("José Jacobo").email("jjoshe093@gmail.com")));
    }
}
