package br.com.gonzagalavajato.gonzaga.carro.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gonzagalavajato.gonzaga.carro.domain.Carro;

public interface CarroSpringDataJPARepository extends JpaRepository<Carro, UUID> {
	List<Carro> findByIdClienteCondutor(UUID idClienteCondutor);
}