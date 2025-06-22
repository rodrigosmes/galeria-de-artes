package com.projeto_galeria.artes.controller;

import com.projeto_galeria.artes.model.ArtistaModel;
import com.projeto_galeria.artes.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artistas")
@CrossOrigin(origins = "*")
public class ArtistaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    @GetMapping
    public ResponseEntity<List<ArtistaModel>> listarTodos() {
        return ResponseEntity.ok(artistaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistaModel> buscarPorId(@PathVariable int id) {
        Optional<ArtistaModel> artista = artistaRepository.findById(id);
        return artista.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArtistaModel> cadastrar(@RequestBody ArtistaModel artista) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artistaRepository.save(artista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistaModel> atualizar(@PathVariable int id, @RequestBody ArtistaModel novo) {
        return artistaRepository.findById(id).map(artista -> {
            artista.setNome(novo.getNome());
            artista.setBiografia(novo.getBiografia());
            artista.setDataNascimento(novo.getDataNascimento());
            return ResponseEntity.ok(artistaRepository.save(artista));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (!artistaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        artistaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
