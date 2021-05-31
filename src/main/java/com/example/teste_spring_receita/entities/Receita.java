package com.example.teste_spring_receita.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Column(name = "tempo_preparo")
    private int tempoPreparo;

    private Integer ingrediente;

    public Receita() {
    }

    public Receita(Long id, String nome, int tempoPreparo, Integer ingrediente) {
        this.id = id;
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
        this.ingrediente = ingrediente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Integer getIngrediente() {
        return ingrediente;
    }

    public void setIngredientes(Integer ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return Objects.equals(id, receita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
