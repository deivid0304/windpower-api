package com.seunome.windpowerapi.controller;

import com.seunome.windpowerapi.model.TurbinaEolica;
import com.seunome.windpowerapi.service.TurbinaEolicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turbinas")
public class TurbinaEolicaController {

    private final TurbinaEolicaService service;

    public TurbinaEolicaController(TurbinaEolicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TurbinaEolica> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurbinaEolica> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TurbinaEolica criar(@RequestBody TurbinaEolica turbina) {
        return service.salvar(turbina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurbinaEolica> atualizar(@PathVariable Long id, @RequestBody TurbinaEolica atualizada) {
        return service.buscarPorId(id)
                .map(turbina -> {
                    turbina.setModelo(atualizada.getModelo());
                    turbina.setPotenciaKw(atualizada.getPotenciaKw());
                    turbina.setParqueEolico(atualizada.getParqueEolico());
                    return ResponseEntity.ok(service.salvar(turbina));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.buscarPorId(id).map(t -> {
            service.deletar(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
// This controller class provides RESTful endpoints for the TurbinaEolica entity.
// It uses the TurbinaEolicaService to handle the business logic and data access.