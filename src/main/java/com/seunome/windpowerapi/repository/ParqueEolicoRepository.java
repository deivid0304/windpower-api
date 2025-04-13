package com.seunome.windpowerapi.repository;

import com.seunome.windpowerapi.model.ParqueEolico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParqueEolicoRepository extends JpaRepository<ParqueEolico, Long> {
}
// This interface extends JpaRepository, which provides CRUD operations for the ParqueEolico entity.
// The first parameter is the entity type (ParqueEolico), and the second parameter is the type of the entity's ID (Long).