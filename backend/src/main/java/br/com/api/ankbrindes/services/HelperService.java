package br.com.api.ankbrindes.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface HelperService<E,R> {
	public List<E> list();
	public Page<E> findAll(Pageable pageable);
	public E findOne(UUID id);
	public E add (E type);
	public void delete(UUID id);
	public E update(R request, UUID id);
	

}
