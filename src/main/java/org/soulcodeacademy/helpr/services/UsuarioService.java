package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.repositories.UsuarioRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario filtrarPorEmail(String email){
        return this.usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Usuário não encontrado"));
    }

    public Usuario filtrarPorCpf(String cpf){
        return this.usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Usuário não encontrado"));
    }

    public List<Usuario> buscarPorNome(String busca){
        return this.usuarioRepository.findByNomeContaining(busca);
    }

    public Perfil verificarPerfilPorId(Integer id){
       Usuario usuario = this.usuarioRepository.findById(id)
               .orElseThrow(() -> new RecursoNaoEncontradoError("Usuário não encontrado"));
       return usuario.getPerfil();

       }

}
