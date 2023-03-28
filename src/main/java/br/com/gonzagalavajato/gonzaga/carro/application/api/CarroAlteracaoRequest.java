package br.com.gonzagalavajato.gonzaga.carro.application.api;

import br.com.gonzagalavajato.gonzaga.carro.domain.TipoCarro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CarroAlteracaoRequest {
	@NotBlank
	private String nomeCarro;
	@NotNull
	private String cor;
	@NotNull
	private TipoCarro tipoCarro;
	private Boolean placaCarro;
	@NotBlank
	private String marca;
}