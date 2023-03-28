package br.com.gonzagalavajato.gonzaga.carro.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.gonzagalavajato.gonzaga.carro.domain.Carro;
import br.com.gonzagalavajato.gonzaga.carro.domain.TipoCarro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CarroClienteListResponse {
	private UUID idCarro;
	@NotBlank
	private String nomeCarro;
	@NotNull
	private String cor;
	@NotNull
	private TipoCarro tipoCarro;
	private Boolean placaCarro;
	@NotBlank
	private String marca;

	public static List<CarroClienteListResponse> converte(List<Carro> carrosDoCliente) {
		return carrosDoCliente.stream()
				.map(CarroClienteListResponse::new)
				.collect(Collectors
						.toList());
	}

	public CarroClienteListResponse(Carro carro) {
		this.idCarro = carro.getIdCarro();
		this.nomeCarro = carro.getNomeCarro();
		this.tipoCarro = carro.getTipoCarro();
		this.cor = carro.getCor();
		this.placaCarro = carro.getPlacaCarro();
		this.marca = carro.getMarca();
	}
}