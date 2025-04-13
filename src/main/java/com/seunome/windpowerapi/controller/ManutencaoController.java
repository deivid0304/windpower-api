package com.seunome.windpowerapi.controller;

import com.seunome.windpowerapi.model.Manutencao;
import com.seunome.windpowerapi.service.ManutencaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manutencoes")
public class ManutencaoController {

    private final ManutencaoService service;

    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Manutencao> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Manutencao criar(@RequestBody Manutencao manutencao) {
        return service.salvar(manutencao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> atualizar(@PathVariable Long id, @RequestBody Manutencao atualizada) {
        return service.buscarPorId(id)
                .map(m -> {
                    m.setData(atualizada.getData());
                    m.setDescricao(atualizada.getDescricao());
                    m.setTurbina(atualizada.getTurbina());
                    return ResponseEntity.ok(service.salvar(m));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.buscarPorId(id).map(m -> {
            service.deletar(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
// This controller class provides RESTful endpoints for the Manutencao entity.
// It uses the ManutencaoService to handle the business logic and data access.