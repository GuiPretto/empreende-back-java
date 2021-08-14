package org.guipretto.empreender.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Empreendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String slug;

    @Column
    private Long contato;

    @Column
    private Long area;

    @Column
    private Long quartos;

    @Column
    private Long vagas;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
