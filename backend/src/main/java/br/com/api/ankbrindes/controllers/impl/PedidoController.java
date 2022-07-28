package br.com.api.ankbrindes.controllers.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.ankbrindes.controllers.IPedidoController;
import br.com.api.ankbrindes.dto.PedidoRequest;
import br.com.api.ankbrindes.models.Pedido;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController implements IPedidoController {

	@Override
	public ResponseEntity<?> cadastrar(PedidoRequest request, BindingResult resultErrors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> atualizar(UUID id, PedidoRequest request, BindingResult resultErrors) {
		// TODO Auto-generated method stub
		return null;
	}

}
