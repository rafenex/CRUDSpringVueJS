package br.com.api.ankbrindes.controllers;


import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;


public interface HelperController<E,R, RL> {
	
	public ResponseEntity<?> cadastrar(R request, RL resultErrors);
	
	public List<E> listar();
	
	public ResponseEntity<?> findById(UUID id);
	
	public ResponseEntity<?> deleteById(UUID id);

	public ResponseEntity<?> atualizar(UUID id, R request, RL resultErrors);
	



}
