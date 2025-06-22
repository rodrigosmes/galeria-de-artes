package com.projeto_galeria.artes.repository;

import com.projeto_galeria.artes.model.ArtistaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<ArtistaModel, Integer> {
}
