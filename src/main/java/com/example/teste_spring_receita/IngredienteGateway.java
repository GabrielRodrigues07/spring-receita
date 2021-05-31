package com.example.teste_spring_receita;

import com.example.teste_spring_receita.dto.IngredienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ingrediente", url = "http://localhost:9000")
public interface IngredienteGateway {

    @GetMapping(value = "/ingredientes/{id}")
    IngredienteDTO findById(@PathVariable("id") Integer ingredienteId);
}
