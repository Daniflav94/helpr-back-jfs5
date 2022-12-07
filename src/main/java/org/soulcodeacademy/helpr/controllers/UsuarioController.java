package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Encontrar usuário por email
    //http://localhost:8080/usuarios/renato.pereira@gmail.com/email
    @GetMapping("/usuarios/{email}/email")
    public Usuario filtrarPorEmail(@PathVariable String email){
        return this.usuarioService.filtrarPorEmail(email);
    }

    // Encontrar usuário pelo cpf
    //http://localhost:8080/usuarios/12659185115/cpf
    @GetMapping("/usuarios/{cpf}/cpf")
    public Usuario filtrarPorCpf(@PathVariable String cpf){
        return this.usuarioService.filtrarPorCpf(cpf);
    }

    // Listar usuários que atendem a busca
    //http://localhost:8080/usuarios/busca?busca=victor
    @GetMapping("/usuarios/busca")
    public List<Usuario> buscarPorNome(@RequestParam String busca){
        return this.usuarioService.buscarPorNome(busca);
    }

    // Exibir o perfil de um usuário buscando pelo id
    //http://localhost:8080/usuarios/2/perfil
    @GetMapping("/usuarios/{id}/perfil")
    public Perfil verificarPerfilPorId(@PathVariable Integer id){
        return this.usuarioService.verificarPerfilPorId(id);
    }
}
