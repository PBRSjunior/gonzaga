package br.com.gonzagalavajato.gonzaga.carro.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroAlteracaoRequest;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroClienteDetalheResponse;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroClienteListResponse;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroRequest;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroResponse;
import br.com.gonzagalavajato.gonzaga.carro.application.repository.CarroRepository;
import br.com.gonzagalavajato.gonzaga.carro.domain.Carro;
import br.com.gonzagalavajato.gonzaga.cliente.application.api.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class CarroApplicationService implements CarroService {
	private final ClienteService clienteService;
	private final CarroRepository carroRepository;

	@Override
	public CarroResponse criaCarro(UUID idCliente, CarroRequest carroRequest) {
		log.info("[start] CarroApplicationService - criaCarro");
		clienteService.buscaClienteAtravesId(idCliente);
		Carro carro = carroRepository.salvaCarro(new Carro(idCliente, carroRequest));
		log.info("[finish] CarroApplicationService - criaCarro");
		return new CarroResponse(carro.getIdCarro());
	}

	@Override
	public List<CarroClienteListResponse> buscaCarrosDoClienteComID(UUID idCliente) {
		log.info("[start] CarroApplicationService - buscaCarrosDoClienteComID");
		clienteService.buscaClienteAtravesId(idCliente);
		List<Carro> carrosDoCliente = carroRepository.buscaCarrosDoClienteComID(idCliente);
		log.info("[finish] CarroApplicationService - buscaCarrosDoClienteComID");
		return CarroClienteListResponse.converte(carrosDoCliente);
	}

	@Override
	public CarroClienteDetalheResponse buscaCarrosDoClienteComID(UUID idCliente, UUID idCarro) {
		log.info("[start] CarroApplicationService - buscaCarroDoClienteComID");
		clienteService.buscaClienteAtravesId(idCliente);
		Carro carro = carroRepository.buscaCarroPeloId(idCarro);
		log.info("[finish] CarroApplicationService - buscacarroDoClienteComID");
		return new CarroClienteDetalheResponse(carro);
	}

	@Override
	public void deleteCarroDoClienteComId(UUID idCliente, UUID idCarro) {
		log.info("[start] CarroApplicationService - deleteCarroDoClienteComId");
		clienteService.buscaClienteAtravesId(idCliente);
		Carro carro = carroRepository.buscaCarroPeloId(idCarro);
		carroRepository.deletaCarro(carro);
		log.info("[start] CarroApplicationService - deleteCarroDoClienteComId");
	}

	@Override
	public void alteraCarroDoClienteComID(UUID idCliente, UUID idCarro, CarroAlteracaoRequest carroAlteracaoRequest) {
		log.info("[start] CarroApplicationService - alteraCarroDoClienteComID");
		clienteService.buscaClienteAtravesId(idCliente);
		Carro carro = carroRepository.buscaCarroPeloId(idCarro);
		carro.altera(carroAlteracaoRequest);
		carroRepository.salvaCarro(carro);
		log.info("[finish] CarroApplicationService - alteraCarroDoClienteComID");
	}
}
