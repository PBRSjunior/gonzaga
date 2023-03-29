package br.com.gonzagalavajato.gonzaga.carro.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.gonzagalavajato.gonzaga.carro.domain.Carro;

public interface CarroRepository {
	Carro salvaCarro(Carro carro);
	List<Carro> buscaCarrosDoClienteComID(UUID idCliente);
	Carro buscaCarroPeloId(UUID idCarro);
	void deletaCarro(Carro carro);
}