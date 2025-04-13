package com.seunome.windpowerapi.service;

import com.seunome.windpowerapi.model.Manutencao;
import com.seunome.windpowerapi.repository.ManutencaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoService {

    private final ManutencaoRepository repository;

    public ManutencaoService(ManutencaoRepository repository) {
        this.repository = repository;
    }

    public List<Manutencao> listarTodas() {
        return repository.findAll();
    }

    public Optional<Manutencao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Manutencao salvar(Manutencao manutencao) {
        return repository.save(manutencao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
// This service class provides methods to interact with the Manutencao entity.
// It uses the ManutencaoRepository to perform CRUD operations.