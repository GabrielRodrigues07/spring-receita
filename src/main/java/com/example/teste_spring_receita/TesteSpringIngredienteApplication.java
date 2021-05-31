package com.example.teste_spring_receita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TesteSpringIngredienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteSpringIngredienteApplication.class, args);
    }

}
