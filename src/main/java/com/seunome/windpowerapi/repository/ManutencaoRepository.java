package com.seunome.windpowerapi.repository;

import com.seunome.windpowerapi.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
