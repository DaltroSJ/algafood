package com.algaworks.algafood.infrastructure.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<FormaPagamento> listar(){
		
		TypedQuery<FormaPagamento> query = manager.createQuery("from Forma_Pagamento", FormaPagamento.class);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public FormaPagamento salvar(FormaPagamento cozinha) {
		
		return  manager.merge(cozinha);
		
	}
	
	public FormaPagamento buscar(Long id) {
		
		return manager.find(FormaPagamento.class, id);
		
	}
	
	@Transactional
	public void remover(FormaPagamento formaPagamento) {
		
		formaPagamento = buscar(formaPagamento.getId());
		
		manager.remove(formaPagamento);
		
	}

	
	
}
