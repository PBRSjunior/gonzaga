package br.com.gonzagalavajato.gonzaga.cliente.application.api.api;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteRequest {

	@NotBlank
	private String nomeCompleto;
	private String celular;
	private String endereco;
	@CPF
	private String cpf;
	@NotNull
	private LocalDate dataNascimento;
	private Boolean aceitaTermos;
}
