package br.com.api.ankbrindes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.ankbrindes.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{
	Boolean existsByNome(String nome);
}
