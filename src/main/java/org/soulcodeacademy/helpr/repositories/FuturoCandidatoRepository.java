package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.enums.Setor;

import java.util.List;
import java.util.Optional;

public interface FuturoCandidatoRepository {
    Optional<FuturoCandidato> findByEmail(String email);

    List<FuturoCandidato> findByNomeContaining(String busca);

    Optional<FuturoCandidato> findBySetor(Setor setor);
}
