package com.example.teste_spring_receita.repositories;

import com.example.teste_spring_receita.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
