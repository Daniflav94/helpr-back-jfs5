package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.services.FuturoCandidatoService;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuturoCandidatoController {

    @Autowired
    private FuturoCandidatoService futuroCandidatoService;

    @GetMapping("/futurocandidato")
    public List<FuturoCandidato> listar() {
        return this.futuroCandidatoService.listarTodos();
    }

    @GetMapping("/futurocandidato/{idFuturoCandidato}")
    public FuturoCandidato filtrarPorId(@PathVariable Integer idFuturoCandidato) {
        return this.futuroCandidatoService.filtrarPorId(idFuturoCandidato);
    }


    @GetMapping("/futurocandidato/setor")
    public FuturoCandidato filtarPorSetor(@RequestParam Setor setor) {
        return this.futuroCandidatoService.filtrarPorSetor(setor);

    }

    @GetMapping("/futurocandidato/email")
    public FuturoCandidato filtrarPorEmail(@RequestParam String email) {
        return this.futuroCandidatoService.filtrarPorEmail(email);
    }

    @GetMapping("/futurocandidato/nome")
    public List<FuturoCandidato> filtrarPorNome(@RequestParam String nome) {
        return this.futuroCandidatoService.filtrarPorNome(nome);
    }

    // POST = Representa inserção de dados
    @PostMapping("/futurocandidato")
    public FuturoCandidato salvar(@Valid @RequestBody FuturoCandidatoDTO dto) {
        FuturoCandidato futuroCandidato = this.futuroCandidatoService.salvar(dto);
        return futuroCandidato;
    }

    @DeleteMapping("/futurocandidato/{idFuturoCandidato}")
    public void deletar(@PathVariable Integer idFuturoCandidato) {
        this.futuroCandidatoService.deletar(idFuturoCandidato);
    }
}