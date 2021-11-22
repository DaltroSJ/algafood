package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Estado> listar(){
		
		TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public Estado salvar(Estado estado) {
		
		return  manager.merge(estado);
		
	}
	
	public Estado buscar(Long id) {
		
		return manager.find(Estado.class, id);
		
	}
	
	@Transactional
	public void remover(Estado estado) {
		
		estado = buscar(estado.getId());
		
		manager.remove(estado);
		
	}

	
	
}
