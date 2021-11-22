package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

public class PermissaoRepositoryImpl implements PermissaoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Permissao> listar(){
		
		TypedQuery<Permissao> query = manager.createQuery("from Permissao", Permissao.class);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public Permissao salvar(Permissao permissao) {
		
		return  manager.merge(permissao);
		
	}
	
	public Permissao buscar(Long id) {
		
		return manager.find(Permissao.class, id);
		
	}
	
	@Transactional
	public void remover(Permissao permissao) {
		
		permissao = buscar(permissao.getId());
		
		manager.remove(permissao);
		
	}

	
	
}
