package com.seunome.windpowerapi.service;

import com.seunome.windpowerapi.model.TurbinaEolica;
import com.seunome.windpowerapi.repository.TurbinaEolicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurbinaEolicaService {

    private final TurbinaEolicaRepository repository;

    public TurbinaEolicaService(TurbinaEolicaRepository repository) {
        this.repository = repository;
    }

    public List<TurbinaEolica> listarTodas() {
        return repository.findAll();
    }

    public Optional<TurbinaEolica> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public TurbinaEolica salvar(TurbinaEolica turbina) {
        return repository.save(turbina);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
//
// This service class provides methods to interact with the TurbinaEolica entity.