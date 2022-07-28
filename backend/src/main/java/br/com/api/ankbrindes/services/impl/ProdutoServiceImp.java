package br.com.api.ankbrindes.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.api.ankbrindes.dto.ProdutoRequest;
import br.com.api.ankbrindes.models.Produto;
import br.com.api.ankbrindes.repositories.ProdutoRepository;
import br.com.api.ankbrindes.services.IProdutoService;

@Service
public class ProdutoServiceImp implements IProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public List<Produto> list() {
		return produtoRepository.findAll();
	}

	@Override
	public Page<Produto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Produto findOne(UUID id) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if(produtoOptional.isEmpty()) {
			throw new RuntimeException("Produto não encontado");
		}
		Produto produto = produtoOptional.get();
		return produto;
	}
	
	
	
	@Override
	@Transactional
	public Produto add(Produto produto) {
		if (produtoRepository.existsByModelo(produto.getModelo())) {
			throw new RuntimeException("Produto já cadastrado");
			} 
		return produtoRepository.save(produto);
	}

	@Override
	@Transactional
	public void delete(UUID id) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if(produtoOptional.isEmpty()) {
			throw new RuntimeException("Produto não encontado");
		}
		produtoRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public Produto update(ProdutoRequest request, UUID id) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if(produtoOptional.isEmpty()) {
			throw new RuntimeException("Produto não encontado");
		}
		Produto produto = produtoOptional.get();
		produto.setCor(request.getCor());
		produto.setFoto(request.getFoto());
		produto.setModelo(request.getModelo());
		produto.setQuantidade(request.getQuantidade());
		produto.setValorUnitario(request.getValorUnitario());
		
		return produto;
	}

}
