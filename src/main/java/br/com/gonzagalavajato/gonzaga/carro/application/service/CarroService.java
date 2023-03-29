package br.com.gonzagalavajato.gonzaga.carro.application.service;

import java.util.List;
import java.util.UUID;

import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroAlteracaoRequest;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroClienteDetalheResponse;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroClienteListResponse;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroRequest;
import br.com.gonzagalavajato.gonzaga.carro.application.api.CarroResponse;

public interface CarroService {
	CarroResponse criaCarro(UUID idCliente, CarroRequest carroRequest);
	List<CarroClienteListResponse> buscaCarrosDoClienteComID(UUID idCliente);
	CarroClienteDetalheResponse buscaCarrosDoClienteComID(UUID idCliente, UUID idCarro);
	void deleteCarroDoClienteComId(UUID idCliente, UUID idCarro);
	void alteraCarroDoClienteComID(UUID idCliente, UUID idCarro, CarroAlteracaoRequest carroAlteracaoRequest);
}
