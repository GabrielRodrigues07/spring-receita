package com.example.teste_spring_receita.dto;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

public class IngredienteDTO {

    private Long id;
    private String nome;
    private UnidadeDTO unidade;

    public IngredienteDTO(Long id, String nome, UnidadeDTO unidade) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
    }


}
