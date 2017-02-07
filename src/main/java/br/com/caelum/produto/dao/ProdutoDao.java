package br.com.caelum.produto.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.produto.modelo.Produto;

@RequestScoped
public class ProdutoDao {

	
	@Inject
	private EntityManager manager;
	
	
	

	public ProdutoDao() {
		
	}
	
	public void adicionar(Produto produto) {
	manager.persist(produto);	
	}
	
	public void atualiza(Produto produto) {
		manager.merge(produto);
	}
	
	public void remove(Produto produto) {
		manager.remove(manager.getReference(Produto.class, produto.getId()));
				
	}
	
	public Produto mostra(Produto produto) {
	return 	manager.find(Produto.class,produto.getId());
	}
	
	public List<Produto> lista() {
		return manager.createQuery("select p FROM Produto p").getResultList();
	}
	
}
