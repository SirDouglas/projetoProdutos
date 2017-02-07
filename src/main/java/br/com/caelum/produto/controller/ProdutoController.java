package br.com.caelum.produto.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.produto.dao.ProdutoDao;
import br.com.caelum.produto.modelo.Produto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class ProdutoController {
	

	private  Result result;
	

	private ProdutoDao dao;
	
	
	/**
     * @deprecated CDI eyes only
     */
    protected ProdutoController() {
        this(null,null);
    }
    
    @Inject
    public ProdutoController(Result result,ProdutoDao dao) {
        this.result = result;
        this.dao = dao;
    }
	
	
	public List<Produto> lista() {
       return dao.lista();
	}
	
	public void adiciona(Produto produto) {
		dao.adicionar(produto);
		result.redirectTo(ProdutoController.class).lista();
	}
	
	
public void formulario() {
	
}

public void altera(Produto produto) {
	dao.atualiza(produto);
	result.redirectTo(ProdutoController.class).lista();
}

public Produto mostra(Produto produto) {
	return dao.mostra(produto);
}
	

	public void remove(Produto produto) {
		
		 dao.remove(produto);
				}
	

}