package br.com.gonzagalavajato.gonzaga.carro.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroAlteracaoRequest;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idCarro", updatable = false, unique = true, nullable = false)
	private UUID idCarro;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idClienteCondutor", nullable = false)
	private UUID idClienteCondutor;
	@NotBlank
	private String nomeCarro;
	private String cor;
	@Enumerated
	private TipoCarro tipoCarro;
	 @Column(unique = true)
	private Boolean placaCarro;
	private String marca;

	private LocalDateTime datahoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public Carro(UUID idCliente, CarroRequest CarroRequest) {
		this.idClienteCondutor = idCliente;
		this.nomeCarro = CarroRequest.getNomeCarro();
		this.tipoCarro = CarroRequest.getTipoCarro();
		this.cor = CarroRequest.getCor();
		this.placaCarro = CarroRequest.getPlacaCarro();
		this.marca = CarroRequest.getMarca();
		this.datahoraDoCadastro = LocalDateTime.now();
	}

	public void altera(CarroAlteracaoRequest carroRequest) {
		this.nomeCarro = carroRequest.getNomeCarro();
		this.tipoCarro = carroRequest.getTipoCarro();
		this.cor = carroRequest.getCor();
		this.placaCarro = carroRequest.getPlacaCarro();
		this.marca = carroRequest.getMarca();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
	}
}
