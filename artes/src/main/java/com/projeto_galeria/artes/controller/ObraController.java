package com.projeto_galeria.artes.controller;

import com.projeto_galeria.artes.model.ObraModel;
import com.projeto_galeria.artes.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/obras")
@CrossOrigin(origins = "*")
public class ObraController {

    @Autowired
    private ObraRepository obraRepository;

    @GetMapping
    public ResponseEntity<List<ObraModel>> listarTodas() {
        return ResponseEntity.ok(obraRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraModel> buscarPorId(@PathVariable int id) {
        Optional<ObraModel> obra = obraRepository.findById(id);
        return obra.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ObraModel>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(obraRepository.findByTituloContainingIgnoreCase(titulo));
    }

    @GetMapping("/artista")
    public ResponseEntity<List<ObraModel>> buscarPorNomeArtista(@RequestParam String nome) {
        return ResponseEntity.ok(obraRepository.findByArtista_NomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<ObraModel> cadastrar(@RequestBody ObraModel obra) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obraRepository.save(obra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraModel> atualizar(@PathVariable int id, @RequestBody ObraModel nova) {
        return obraRepository.findById(id).map(obra -> {
            obra.setTitulo(nova.getTitulo());
            obra.setDescricao(nova.getDescricao());
            obra.setDataCriacao(nova.getDataCriacao());
            obra.setImagemUrl(nova.getImagemUrl());
            obra.setArtista(nova.getArtista());
            return ResponseEntity.ok(obraRepository.save(obra));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (!obraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        obraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
