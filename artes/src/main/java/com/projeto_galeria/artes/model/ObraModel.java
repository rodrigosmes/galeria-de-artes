package com.projeto_galeria.artes.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.time.LocalDate;

@Data
@Entity
public class ObraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    @Column(length = 2000)
    private String descricao;

    private LocalDate dataCriacao;

    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private ArtistaModel artista;

    @ManyToMany
    @JoinTable(
            name = "artes_obra",
            joinColumns = @JoinColumn(name = "artes_id"),
            inverseJoinColumns = @JoinColumn(name = "obra_id")
    )
    private List<ObraModel> obras;
}
