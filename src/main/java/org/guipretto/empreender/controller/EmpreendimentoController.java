package org.guipretto.empreender.controller;

import com.github.slugify.Slugify;
import org.guipretto.empreender.entity.Empreendimento;
import org.guipretto.empreender.exception.EmpreendimentoException;
import org.guipretto.empreender.service.model.EmpreendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empreendimento")
public class EmpreendimentoController {

    @Autowired
    private EmpreendimentoService empreendimentoService;

    @GetMapping
    public List<Empreendimento> getAllEmpreendimento(@RequestParam("nome") String nome, @RequestParam("quartos") Long quartos) {
        return empreendimentoService.findAll(nome, quartos);
    }

    @PostMapping
    public Empreendimento salvarEmpreendimento(@RequestBody Empreendimento empreendimento) {
        Slugify slg = new Slugify();
        Empreendimento novoEmpreendimento = empreendimentoService.findBySlug(slg.slugify(empreendimento.getNome()));
        if (novoEmpreendimento != null) {
            throw new EmpreendimentoException("Já existe uma empreendimento com este nome.", HttpStatus.CONFLICT);
        }
        return empreendimentoService.salvarEmpreendimento(empreendimento);
    }

    @PutMapping
    public Empreendimento atualizarEmpreendimento(@RequestBody Empreendimento empreendimento) {
        Slugify slg = new Slugify();
        Empreendimento empreendimentoExistente = empreendimentoService.findBySlug(slg.slugify(empreendimento.getNome()));
        if (empreendimentoExistente == null) {
            throw new EmpreendimentoException("Não existe um empreendimento com este nome.", HttpStatus.NOT_FOUND);
        }
        return empreendimentoService.atualizarEmpreendimento(empreendimento);
    }

    @DeleteMapping("/{empreendimentoId}")
    public void deletarEmpreendimento(@PathVariable Long empreendimentoId) {
        Empreendimento empreendimento = empreendimentoService.findById(empreendimentoId);
        if (empreendimento == null) {
            throw new EmpreendimentoException("Empreendimento não existe.", HttpStatus.NOT_FOUND);
        }
        empreendimentoService.deletarEmpreendimento(empreendimentoId);
    }

    @GetMapping("/getEmpreendimentoPorSlug/{empreendimentoSlug}")
    public Empreendimento getEmpreendimento(@PathVariable String empreendimentoSlug){
        Empreendimento empreendimento = empreendimentoService.findBySlug(empreendimentoSlug);
        if (empreendimento == null) {
            throw new EmpreendimentoException("Empreendimento não existe.", HttpStatus.NOT_FOUND);
        }
        return empreendimento;
    }

    @GetMapping("/getEmpreendimentoPorId/{empreendimentoId}")
    public Empreendimento getEmpreendimento(@PathVariable Long empreendimentoId){
        Empreendimento empreendimento = empreendimentoService.findById(empreendimentoId);
        if (empreendimento == null) {
            throw new EmpreendimentoException("Empreendimento não existe.", HttpStatus.NOT_FOUND);
        }
        return empreendimento;
    }
}
