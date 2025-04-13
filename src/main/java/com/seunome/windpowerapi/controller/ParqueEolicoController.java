package com.seunome.windpowerapi.controller;

import com.seunome.windpowerapi.model.ParqueEolico;
import com.seunome.windpowerapi.service.ParqueEolicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parques")
public class ParqueEolicoController {

    private final ParqueEolicoService service;

    public ParqueEolicoController(ParqueEolicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ParqueEolico> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParqueEolico> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ParqueEolico criar(@RequestBody ParqueEolico parque) {
        return service.salvar(parque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParqueEolico> atualizar(@PathVariable Long id, @RequestBody ParqueEolico parqueAtualizado) {
        return service.buscarPorId(id)
                .map(parque -> {
                    parque.setNome(parqueAtualizado.getNome());
                    parque.setLocalizacao(parqueAtualizado.getLocalizacao());
                    return ResponseEntity.ok(service.salvar(parque));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.buscarPorId(id).map(p -> {
            service.deletar(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
// This controller class provides RESTful endpoints for the ParqueEolico entity.
// It uses the ParqueEolicoService to handle the business logic and data access.