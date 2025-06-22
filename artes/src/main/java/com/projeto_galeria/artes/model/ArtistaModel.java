package com.projeto_galeria.artes.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class ArtistaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 2000)
    private String biografia;

    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<ObraModel> obras;
}
