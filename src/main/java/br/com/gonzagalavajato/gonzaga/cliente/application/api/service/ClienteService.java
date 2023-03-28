package br.com.gonzagalavajato.gonzaga.cliente.application.api.service;

import java.util.List;
import java.util.UUID;

import br.com.gonzagalavajato.gonzaga.cliente.application.api.api.ClienteAlteracaoRequest;
import br.com.gonzagalavajato.gonzaga.cliente.application.api.api.ClienteDetalhadoResponse;
import br.com.gonzagalavajato.gonzaga.cliente.application.api.api.ClienteListResponse;
import br.com.gonzagalavajato.gonzaga.cliente.application.api.api.ClienteRequest;
import br.com.gonzagalavajato.gonzaga.cliente.application.api.api.ClienteResponse;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
	ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente);
	void deletaClienteAtravesId(UUID idCliente);
	void patchAlteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);
}