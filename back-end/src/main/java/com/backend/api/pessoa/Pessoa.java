package com.backend.api.pessoa;

import com.backend.api.core.AbstractEntity;
import com.backend.api.core.validation.BirthDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pessoa extends AbstractEntity {

    @Column(name = "nome")
    @NotEmpty(message = "Nome cannot be null or empty")
    private String nome;

    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "email")
    @Email(message = "Invalid e-mail adress")
    private String email;

    @Column(name = "data_nascimento")
    @NotNull(message = "dataNascimento cannot be null or empty")
    @BirthDate(message = "Invalid date (value cannot be greater than today)")
    private LocalDate dataNascimento;

    @Column(name = "naturalidade")
    private String naturalidade;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(name = "cpf")
    @NotEmpty(message = "CPF cannot be null or empty")
    @CPF(message = "Invalid CPF")
    private String cpf;
}
