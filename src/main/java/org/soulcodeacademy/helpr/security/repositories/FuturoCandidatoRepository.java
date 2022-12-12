package org.soulcodeacademy.helpr.security.repositories;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuturoCandidatoRepository extends JpaRepository<FuturoCandidato, Integer> {

    Optional<FuturoCandidato> findByEmail(String email);

    List<FuturoCandidato> findByNomeContaining(String busca);

    Optional<FuturoCandidato> findBySetor(Setor setor);

    List<FuturoCandidato> findAll();

    FuturoCandidato save(FuturoCandidato novoFuturoCandidato);

}
