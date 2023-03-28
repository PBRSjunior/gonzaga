package br.com.gonzagalavajato.gonzaga.cliente.application.api.api;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteAlteracaoRequest {

	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private String celular;
	@NotBlank
	private String endereco;
	@CPF
	private String cpf;
	@NotNull
	private Boolean aceitaTermos;
}