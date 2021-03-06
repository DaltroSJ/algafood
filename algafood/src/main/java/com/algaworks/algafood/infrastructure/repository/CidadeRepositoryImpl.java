package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class CidadeRepositoryImpl implements CidadeRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Cidade> listar(){
		
		TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public Cidade salvar(Cidade cidade) {
		
		return  manager.merge(cidade);
		
	}
	
	public Cidade buscar(Long id) {
		
		return manager.find(Cidade.class, id);
		
	}
	
	@Transactional
	public void remover(Cidade cidade) {
		
		cidade = buscar(cidade.getId());
		
		manager.remove(cidade);
		
	}

	
	
}
