package br.com.gonzagalavajato.gonzaga.cliente.application.api.api;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.gonzagalavajato.gonzaga.cliente.domain.Cliente;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse {

	private UUID idCliente;
	private String nomeCompleto;
	private String celular;
	private String endereco;
	private String cpf;
	private Boolean aceitaTermos;
	private LocalDateTime datahoraDoCadastro;

	public ClienteDetalhadoResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.celular = cliente.getCelular();
		this.endereco = cliente.getEndereco();
		this.cpf = cliente.getCpf();
		this.aceitaTermos = cliente.getAceitaTermos();
		this.datahoraDoCadastro = cliente.getDataHoraDaUltimaAlteracao();
	}
}