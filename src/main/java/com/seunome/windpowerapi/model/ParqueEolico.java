package com.seunome.windpowerapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ParqueEolico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String localizacao;

    @OneToMany(mappedBy = "parqueEolico", cascade = CascadeType.ALL)
    private List<TurbinaEolica> turbinas;

    // Getters e setters

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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<TurbinaEolica> getTurbinas() {
        return turbinas;
    }

    public void setTurbinas(List<TurbinaEolica> turbinas) {
        this.turbinas = turbinas;
    }
}
