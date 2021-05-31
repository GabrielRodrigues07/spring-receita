package com.example.teste_spring_receita.services;

import com.example.teste_spring_receita.IngredienteGateway;
import com.example.teste_spring_receita.dto.IngredienteDTO;
import com.example.teste_spring_receita.entities.Receita;
import com.example.teste_spring_receita.error.ResourceNotFoundException;
import com.example.teste_spring_receita.repositories.ReceitaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    @Autowired
    IngredienteGateway ingredienteGateway;

    public List<Receita> findAll() {
        return repository.findAll();
    }

    public Receita findById(Long id) {
        Optional<Receita> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada, ID: " + id));
    }

    public Receita insert(Receita obj) {
        try {
            IngredienteDTO ingredienteDTO = ingredienteGateway.findById(obj.getIngrediente());
        } catch (FeignException e) {
            throw new ResourceNotFoundException("Ingrediente não encontrado.");
        } catch (Exception ex) {
            throw new ResourceNotFoundException(ex.getMessage());
        }
        return repository.save(obj);
    }

    public void delete(Long id) {
        verifyIfNotExists(id);
        repository.deleteById(id);
    }

    public Receita update(Receita receita) {
        verifyIfNotExists(receita.getId());
        return repository.save(receita);
    }

    private void verifyIfNotExists(Long id) {
        if (repository.findById(id) == null)
            throw new ResourceNotFoundException("Receita não encontrada, ID: " + id);
    }
}