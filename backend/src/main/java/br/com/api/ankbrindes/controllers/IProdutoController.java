package br.com.api.ankbrindes.controllers;

import org.springframework.validation.BindingResult;

import br.com.api.ankbrindes.dto.ClienteRequest;
import br.com.api.ankbrindes.dto.ProdutoRequest;
import br.com.api.ankbrindes.models.Cliente;
import br.com.api.ankbrindes.models.Produto;

public interface IProdutoController extends HelperController<Produto, ProdutoRequest, BindingResult>{

}
