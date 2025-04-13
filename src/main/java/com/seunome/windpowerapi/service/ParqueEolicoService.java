package com.seunome.windpowerapi.service;

import com.seunome.windpowerapi.model.ParqueEolico;
import com.seunome.windpowerapi.repository.ParqueEolicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParqueEolicoService {

    private final ParqueEolicoRepository repository;

    public ParqueEolicoService(ParqueEolicoRepository repository) {
        this.repository = repository;
    }

    public List<ParqueEolico> listarTodos() {
        return repository.findAll();
    }

    public Optional<ParqueEolico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ParqueEolico salvar(ParqueEolico parque) {
        return repository.save(parque);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

// This service class provides methods to interact with the ParqueEolico entity.
// It uses the ParqueEolicoRepository to perform CRUD operations.