package org.guipretto.empreender.repository;

import org.guipretto.empreender.entity.Empreendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long>{
    Empreendimento findBySlug(String slug);

    List<Empreendimento> findByNomeContainingAndQuartos(String nome, Long quartos);

    List<Empreendimento> findByNomeContaining(String nome);

    Empreendimento findByNome(String nome);
}
