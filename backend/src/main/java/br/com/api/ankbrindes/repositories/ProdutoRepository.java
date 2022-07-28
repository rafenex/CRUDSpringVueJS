package br.com.api.ankbrindes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.ankbrindes.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
	Boolean existsByModelo(String nome);
}
