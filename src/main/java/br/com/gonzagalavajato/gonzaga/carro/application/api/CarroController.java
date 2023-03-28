package br.com.gonzagalavajato.gonzaga.carro.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.gonzagalavajato.gonzaga.carro.application.service.CarroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CarroController implements CarroApi {
	private final CarroService carroService;

	@Override
	public CarroResponse postCarro(UUID idCliente, CarroRequest CarroRequest) {
		log.info("[inicia] CarroController - postCarro");
		log.info("[idCliente] {}", idCliente);
		CarroResponse carro = carroService.criaCarro(idCliente, CarroRequest);
		log.info("[finaliza] CarroController - postCarro");
		return carro;
	}

	@Override
	public List<CarroClienteListResponse> getCarrosDoClienteComId(UUID idCliente) {
		log.info("[inicia] CarroController - getCarrosDoClienteComId");
		log.info("[idCliente] {}", idCliente);
		List<CarroClienteListResponse> carrrosDoCliente = carroService.buscaCarrosDoClienteComID(idCliente);
		log.info("[finaliza] CarroController - getCarrosDoClienteComId");
		return carrrosDoCliente;
	}

	@Override
	public CarroClienteDetalheResponse getClienteAtravesId(UUID idCliente, UUID idCarro) {
		log.info("[inicia] CarroController - getClienteAtravesId");
		log.info("[idCliente]{} - [idCarro] {}", idCliente, idCarro);
		CarroClienteDetalheResponse carro = carroService.buscaCarrosDoClienteComID(idCliente, idCarro);
		log.info("[finaliza] CarroController - getCarroDoClienteComId");
		return carro;
	}

	@Override
	public void deleteCarroDoClienteComId(UUID idCliente, UUID idCarro) {
		log.info("[inicia] CarroController - deleteCarroDoClienteComId");
		log.info("[idCliente]{} - [idCarro] {}", idCliente, idCarro);
		carroService.deleteCarroDoClienteComId(idCliente, idCarro);
		log.info("[finaliza] CarroController - deleteCarroDoClienteComId");
	}

	@Override
	public void patchCarro(UUID idCliente, UUID idCarro, @Valid CarroAlteracaoRequest carroAlteracaoRequest) {
		log.info("[inicia] CarroController - patchCarro");
		log.info("[idCliente]{} - [idCarro] {}", idCliente, idCarro);
		carroService.alteraCarroDoClienteComID(idCliente, idCarro, carroAlteracaoRequest);
		log.info("[finaliza] CarroController - patchCarro");
	}
}