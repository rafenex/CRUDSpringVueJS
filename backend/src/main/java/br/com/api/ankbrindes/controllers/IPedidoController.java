package br.com.api.ankbrindes.controllers;

import org.springframework.validation.BindingResult;

import br.com.api.ankbrindes.dto.PedidoRequest;
import br.com.api.ankbrindes.models.Pedido;

public interface IPedidoController extends HelperController<Pedido, PedidoRequest, BindingResult>{

}
	