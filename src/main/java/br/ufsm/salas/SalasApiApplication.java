package br.ufsm.salas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "API de salas UFSM",
                version = "1.0",
                description = "Documentação do módulo de cadastro de salas da UFSM",
                contact = @Contact(name = "Suporte Técnico", email = "suporte@ufsm.br")
        )
)
@SpringBootApplication
public class SalasApiApplication {
    public static void main(final String[] args) {
        SpringApplication.run(SalasApiApplication.class, args);
    }
}
