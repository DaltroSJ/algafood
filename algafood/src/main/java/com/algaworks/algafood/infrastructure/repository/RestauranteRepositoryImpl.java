package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Restaurante> listar(){
		
		TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		
		return  manager.merge(restaurante);
		
	}
	
	public Restaurante buscar(Long id) {
		
		return manager.find(Restaurante.class, id);
		
	}
	
	@Transactional
	public void remover(Restaurante restaurante) {
		
		restaurante = buscar(restaurante.getId());
		
		manager.remove(restaurante);
		
	}

	
	
}
