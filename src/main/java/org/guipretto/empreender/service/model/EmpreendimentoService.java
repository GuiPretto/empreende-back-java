package org.guipretto.empreender.service.model;

import org.guipretto.empreender.entity.Empreendimento;

import java.util.List;

public interface EmpreendimentoService {
    List<Empreendimento> findAll(String nome, Long quartos);

    Empreendimento findById(Long id);

    Empreendimento findBySlug(String slug);

    Empreendimento findByNome(String nome);

    Empreendimento salvarEmpreendimento(Empreendimento empreendimento);

    Empreendimento atualizarEmpreendimento(Empreendimento empreendimento);

    void deletarEmpreendimento(Long id);
}
