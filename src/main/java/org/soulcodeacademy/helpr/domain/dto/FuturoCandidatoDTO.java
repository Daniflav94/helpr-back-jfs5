package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.NotBlank;

public class FuturoCandidatoDTO {
    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;
    @NotBlank(message = "Campo email é obrigatório")
    private String email;
    @NotBlank(message = "Campo descricao é obrigatório")
    private String descricao;
    @NotBlank(message = "Campo setor é obrigatório")
    private Setor setor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Setor getSetor() {
        return setor;
    }


    public void setSetor(Setor setor) { //importar enum
        this.setor = setor;
    }
}
