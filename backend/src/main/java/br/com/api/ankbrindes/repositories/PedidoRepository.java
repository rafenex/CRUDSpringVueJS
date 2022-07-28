package br.com.api.ankbrindes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.ankbrindes.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, UUID>{

}
