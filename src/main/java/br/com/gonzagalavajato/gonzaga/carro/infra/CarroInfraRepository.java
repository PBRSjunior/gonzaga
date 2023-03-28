package br.com.gonzagalavajato.gonzaga.carro.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.gonzagalavajato.gonzaga.carro.application.repository.CarroRepository;
import br.com.gonzagalavajato.gonzaga.carro.domain.Carro;
import br.com.gonzagalavajato.gonzaga.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarroInfraRepository implements CarroRepository {
	private final CarroSpringDataJPARepository carroSpringDataJPARepository;
	
	@Override
	public Carro salvaCarro(Carro carro) {
		log.info("[start]CarroInfraRepository - salvaCarro");
		carroSpringDataJPARepository.save(carro);
		log.info("[finish]CarroInfraRepository - salvaCarro");
		return carro;
	}

	@Override
	public List<Carro> buscaCarrosDoClienteComID(UUID idCliente) {
		log.info("[start]CarroInfraRepository - buscaCarrosDoClienteComID");
		var carros = carroSpringDataJPARepository.findByIdClienteCondutor(idCliente);
		log.info("[finisht]CarroInfraRepository - buscaCarrosDoClienteComID");
		return carros;
	}

	@Override
	public Carro buscaCarroPeloId(UUID idCarro) {
		log.info("[start]CarroInfraRepository - buscaCarroPeloId");
		var carro = carroSpringDataJPARepository.findById(idCarro)
				.orElseThrow(() -> ApiException.build(HttpStatus.NOT_FOUND, "Carro nao encontrado = " + idCarro));
		log.info("[finish]CarroInfraRepository - buscaCarroPeloId");
		return carro;
	}

	@Override
	public void deletaCarro(Carro carro) {
		log.info("[start]CarroInfraRepository - deletaCarro");
		carroSpringDataJPARepository.delete(carro);
		log.info("[finish]CarroInfraRepository - deletaCarro");
	}
}