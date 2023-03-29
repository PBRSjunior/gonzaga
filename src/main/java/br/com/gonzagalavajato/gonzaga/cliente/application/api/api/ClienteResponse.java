package br.com.gonzagalavajato.gonzaga.cliente.application.api.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClienteResponse {

	private UUID idCliente;
}
