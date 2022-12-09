package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service // instanciar automaticamente minha classe
public class FuturoCandidatoService {

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;


    public List<FuturoCandidato> listarTodos() {
        return this.futuroCandidatoRepository.findAll();
    }

    public FuturoCandidato filtrarPorId(Integer idFuturoFuncionario) {
        return this.futuroCandidatoRepository.findById(idFuturoFuncionario)
                .orElseThrow(() -> new RecursoNaoEncontradoError("FuturoCandidato não encontrado!"));

    }
    public List<FuturoCandidato> filtrarPorNome(String nome) {
        return this.futuroCandidatoRepository.findByNomeContaining(nome);
    }

    public FuturoCandidato filtrarPorSetor(Setor setor) {
        return this.futuroCandidatoRepository.findBySetor(setor)
                .orElseThrow(() -> new RecursoNaoEncontradoError("FuturoCandidato não encontrado!"));

    }

    public FuturoCandidato filtrarPorEmail(String email) {
        return this.futuroCandidatoRepository.findByEmail(email)
                .orElseThrow(()-> new RecursoNaoEncontradoError("FuturoCandidato não encontrado!"));
    }


    public FuturoCandidato salvar(FuturoCandidatoDTO dto) {
        FuturoCandidato novoFuturoCandidato = new FuturoCandidato(null, dto.getNome(), dto.getEmail(), dto.getDescricao(), dto.getSetor());
        return this.futuroCandidatoRepository.save(novoFuturoCandidato);
    }

    public void deletar(Integer idFuturoCandidato) {
        FuturoCandidato futuroCandidato = this.filtrarPorId(idFuturoCandidato);
        this.futuroCandidatoRepository.delete(futuroCandidato);
    }
}







