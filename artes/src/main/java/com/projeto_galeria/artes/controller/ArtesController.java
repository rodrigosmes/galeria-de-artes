package com.projeto_galeria.artes.controller;

import com.projeto_galeria.artes.model.ArtesModel;
import com.projeto_galeria.artes.repository.ArtesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artes")
@CrossOrigin(origins = "*")
public class ArtesController {

    @Autowired
    private ArtesRepository artesRepository;

    @GetMapping
    public ResponseEntity<List<ArtesModel>> listarTodas() {
        return ResponseEntity.ok(artesRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtesModel> buscarPorId(@PathVariable int id) {
        Optional<ArtesModel> artes = artesRepository.findById(id);
        return artes.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ArtesModel>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(artesRepository.findByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<ArtesModel> cadastrar(@RequestBody ArtesModel artes) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artesRepository.save(artes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtesModel> atualizar(@PathVariable int id, @RequestBody ArtesModel nova) {
        return artesRepository.findById(id).map(artes -> {
            artes.setNome(nova.getNome());
            artes.setDescricao(nova.getDescricao());
            artes.setData(nova.getData());
            artes.setObras(nova.getObras());
            return ResponseEntity.ok(artesRepository.save(artes));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (!artesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        artesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
