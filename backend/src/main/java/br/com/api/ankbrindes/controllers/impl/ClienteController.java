package br.com.api.ankbrindes.controllers.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.ankbrindes.controllers.IClienteController;
import br.com.api.ankbrindes.dto.ClienteRequest;
import br.com.api.ankbrindes.models.Cliente;
import br.com.api.ankbrindes.services.HelperService;

@CrossOrigin
@RestController
@RequestMapping("/api/clientes")
public class ClienteController implements IClienteController {
	
	@Autowired
	HelperService<Cliente, ClienteRequest> clienteService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteRequest request, BindingResult resultErrors){
		try {
			if (resultErrors.hasErrors()) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(resultErrors.getFieldError().getDefaultMessage());
			}
			Cliente cliente = new Cliente();
			BeanUtils.copyProperties(request, cliente);		
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.add(cliente));			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}		
	}
	
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteService.list();
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		try {
			return ResponseEntity.ok(clienteService.findOne(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable UUID id){
		try {
			clienteService.delete(id);
			return ResponseEntity.ok().body("Cliente deletado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable UUID id, 
									   @RequestBody @Valid ClienteRequest request, BindingResult resultErrors){
		try {
			if (resultErrors.hasErrors()) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(resultErrors.getFieldError().getDefaultMessage());
			}	
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.update(request, id));			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}		
		
	}

}
