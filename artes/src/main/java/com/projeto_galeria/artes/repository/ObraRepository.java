package com.projeto_galeria.artes.repository;

import com.projeto_galeria.artes.model.ObraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObraRepository extends JpaRepository<ObraModel, Integer> {
    List<ObraModel> findByTituloContainingIgnoreCase(String titulo);
    List<ObraModel> findByArtista_NomeContainingIgnoreCase(String nome);
}
