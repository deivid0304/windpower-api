package com.seunome.windpowerapi.repository;

import com.seunome.windpowerapi.model.TurbinaEolica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurbinaEolicaRepository extends JpaRepository<TurbinaEolica, Long> {
}
// This interface extends JpaRepository, which provides CRUD operations for the TurbinaEolica entity.
// The first parameter is the entity type (TurbinaEolica), and the second parameter is the type of the entity's ID (Long).