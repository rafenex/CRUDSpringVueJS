package br.com.api.ankbrindes.controllers.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.ankbrindes.controllers.IProdutoController;
import br.com.api.ankbrindes.dto.ProdutoRequest;
import br.com.api.ankbrindes.models.Produto;
import br.com.api.ankbrindes.services.IProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController implements IProdutoController {
	
	@Autowired
	IProdutoService produtoService;

	@Override
	public ResponseEntity<?> cadastrar(ProdutoRequest request, BindingResult resultErrors) {
		try {
			if (resultErrors.hasErrors()) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(resultErrors.getFieldError().getDefaultMessage());
			}
			Produto produto = new Produto();
			BeanUtils.copyProperties(request, produto);		
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.add(produto));			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}	
	}

	@Override
	public List<Produto> listar() {
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
	public ResponseEntity<?> atualizar(UUID id, ProdutoRequest request, BindingResult resultErrors) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
