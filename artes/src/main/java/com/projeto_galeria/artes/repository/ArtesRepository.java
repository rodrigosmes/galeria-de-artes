package com.projeto_galeria.artes.repository;

import com.projeto_galeria.artes.model.ArtesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtesRepository extends JpaRepository<ArtesModel, Integer> {
    List<ArtesModel> findByNomeContainingIgnoreCase(String nome);
}
