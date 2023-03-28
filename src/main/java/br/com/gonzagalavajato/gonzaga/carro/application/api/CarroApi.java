package br.com.gonzagalavajato.gonzaga.carro.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/carro")
public interface CarroApi {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	CarroResponse postCarro(@PathVariable UUID idCliente, @Valid @RequestBody CarroRequest carroRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<CarroClienteListResponse> getCarrosDoClienteComId(@PathVariable @Valid UUID idCliente);

	@GetMapping(value = "/{idCarro}")
	@ResponseStatus(code = HttpStatus.OK)
	CarroClienteDetalheResponse getClienteAtravesId(@PathVariable UUID idCliente, @PathVariable UUID idCarro);

	@DeleteMapping(value = "/{idCarro}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deleteCarroDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idCarro);

	@PatchMapping(value = "/{idCarro}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchCarro(@PathVariable UUID idCliente, @PathVariable UUID idCarro,
			@Valid @RequestBody CarroAlteracaoRequest CarroAlteracaoRequest);
}