package br.com.api.ankbrindes.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.api.ankbrindes.dto.ClienteRequest;
import br.com.api.ankbrindes.models.Cliente;
import br.com.api.ankbrindes.repositories.ClienteRepository;
import br.com.api.ankbrindes.services.IClienteService;

@Service
public class ClienteServiceImp implements IClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> list() {
		return clienteRepository.findAll();
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cliente findOne(UUID id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if(clienteOptional.isEmpty()) {
			throw new RuntimeException("Cliente não encontado");
		}
		Cliente cliente = clienteOptional.get();
		return cliente;
	}
	
	
	
	@Override
	@Transactional
	public Cliente add(Cliente cliente) {
		if (clienteRepository.existsByNome(cliente.getNome())) {
			throw new RuntimeException("Nome já cadastrado");
			} 
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(UUID id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if(clienteOptional.isEmpty()) {
			throw new RuntimeException("Cliente não encontado");
		}
		clienteRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public Cliente update(ClienteRequest request, UUID id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if(clienteOptional.isEmpty()) {
			throw new RuntimeException("Cliente não encontado");
		}
		Cliente cliente = clienteOptional.get();
		cliente.setCpfOuCnpj(request.getCpfOuCnpj());
		cliente.setEndereco(request.getEndereco());
		cliente.setNome(request.getNome());
		cliente.setTelefone(request.getTelefone());		
		return cliente;
	}

}
