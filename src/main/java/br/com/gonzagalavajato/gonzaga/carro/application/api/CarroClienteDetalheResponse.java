package br.com.gonzagalavajato.gonzaga.carro.application.api;

import br.com.gonzagalavajato.gonzaga.carro.domain.Carro;
import br.com.gonzagalavajato.gonzaga.carro.domain.TipoCarro;
import lombok.Value;

@Value
public class CarroClienteDetalheResponse {

	private String nomeCarro;
	private String cor;
	private TipoCarro tipoCarro;
	private Boolean placaCarro;
	private String marca;

	public CarroClienteDetalheResponse(Carro carro) {
		this.nomeCarro = carro.getNomeCarro();
		this.tipoCarro = carro.getTipoCarro();
		this.cor = carro.getCor();
		this.placaCarro = carro.getPlacaCarro();
		this.marca = carro.getMarca();
	}
}
