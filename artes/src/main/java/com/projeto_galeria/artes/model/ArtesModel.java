package com.projeto_galeria.artes.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class ArtesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Column(length = 2000)
    private String descricao;

    private LocalDate data;

    @ManyToMany
    @JoinTable(
            name = "artes_obra",
            joinColumns = @JoinColumn(name = "artes_id"),
            inverseJoinColumns = @JoinColumn(name = "obra_id")
    )
    private List<ObraModel> obras;
}
