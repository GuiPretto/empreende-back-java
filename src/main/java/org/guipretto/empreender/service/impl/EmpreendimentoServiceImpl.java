package org.guipretto.empreender.service.impl;

import org.guipretto.empreender.entity.Empreendimento;
import org.guipretto.empreender.repository.EmpreendimentoRepository;
import org.guipretto.empreender.service.model.EmpreendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpreendimentoServiceImpl implements EmpreendimentoService {

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    @Override
    public List<Empreendimento> findAll(String nome, Long quartos) {
        if (quartos != 0) {
            return empreendimentoRepository.findByNomeContainingAndQuartos(nome, quartos);
        } else {
            return empreendimentoRepository.findByNomeContaining(nome);
        }
    }

    @Override
    public Empreendimento findById(Long id) {
        return empreendimentoRepository.findById(id).orElse(null);
    }

    @Override
    public Empreendimento findBySlug(String slug) {
        return empreendimentoRepository.findBySlug(slug);
    }

    @Override
    public Empreendimento findByNome(String nome) {
        return empreendimentoRepository.findByNome(nome);
    }

    @Override
    public Empreendimento salvarEmpreendimento(Empreendimento empreendimento) {
        return empreendimentoRepository.save(empreendimento);
    }

    @Override
    public Empreendimento atualizarEmpreendimento(Empreendimento empreendimento) {
        return empreendimentoRepository.save(empreendimento);
    }

    @Override
    public void deletarEmpreendimento(Long id) {
        empreendimentoRepository.deleteById(id);
    }
}
