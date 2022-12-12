package org.soulcodeacademy.helpr.domain.dto;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.context.annotation.Primary;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DependenteDTO {
    @NotNull(message = "ID do funcionário é obrigatório")
    private Integer idResponsavel;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @CPF(message = "CPF é inválido")
    @NotBlank(message = "Senha é obrigatória")
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate DataNascimento;

    @NotBlank(message = "Escolaridade é obrigatória")
    private String escolaridade;

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
}
