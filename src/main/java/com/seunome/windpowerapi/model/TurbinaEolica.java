package com.seunome.windpowerapi.model;

import jakarta.persistence.*;

@Entity
public class TurbinaEolica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private double potenciaKw;

    @ManyToOne
    @JoinColumn(name = "parque_eolico_id")
    private ParqueEolico parqueEolico;

    public Object getModelo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getModelo'");
    }

    public void setModelo(Object modelo2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setModelo'");
    }

    public Object getPotenciaKw() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPotenciaKw'");
    }

    public void setPotenciaKw(Object potenciaKw2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPotenciaKw'");
    }

    public Object getParqueEolico() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getParqueEolico'");
    }

    public void setParqueEolico(Object parqueEolico2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setParqueEolico'");
    }

    // Getters e setters
}
    