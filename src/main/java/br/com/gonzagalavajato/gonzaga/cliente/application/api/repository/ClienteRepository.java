package br.com.gonzagalavajato.gonzaga.cliente.application.api.repository;

import java.util.List;
import java.util.UUID;

import br.com.gonzagalavajato.gonzaga.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
	Cliente buscaClienteAtravesId(UUID idCliente);
	void deletaCliente(Cliente cliente);
}