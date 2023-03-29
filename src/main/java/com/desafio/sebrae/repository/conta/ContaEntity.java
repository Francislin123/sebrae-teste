package com.desafio.sebrae.repository.conta;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Entity
@Table(name = "tab_conta")
public class ContaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "conta_nome")
    public String nome;

    @Column(name = "conta_descricao")
    public String descricao;

    @Tolerate
    public ContaEntity() {
       // Default constructor for hibernate
    }

    @Builder
    public ContaEntity(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
