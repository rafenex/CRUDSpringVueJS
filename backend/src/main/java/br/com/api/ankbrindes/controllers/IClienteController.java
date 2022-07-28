package br.com.api.ankbrindes.controllers;

import org.springframework.validation.BindingResult;

import br.com.api.ankbrindes.dto.ClienteRequest;
import br.com.api.ankbrindes.models.Cliente;

public interface IClienteController extends HelperController<Cliente, ClienteRequest, BindingResult>{

}
