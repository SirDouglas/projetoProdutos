package br.com.caelum.produto.controller;

import javax.inject.Inject;

import br.com.caelum.produto.component.UsuarioLogado;
import br.com.caelum.produto.dao.UsuarioDao;
import br.com.caelum.produto.interceptor.UsuarioInfo;
import br.com.caelum.produto.modelo.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;



@Controller
public class LoginController {
	

	private UsuarioDao usuarioDao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private UsuarioInfo usuarioInfo;
	
	/**
     * @deprecated CDI eyes only
     */
    protected LoginController() {
        this(null,null,null,null);
    }
    
    @Inject
    public LoginController(Result result,UsuarioDao dao,UsuarioLogado usuarioLogado,UsuarioInfo usuarioInfo) {
        this.result = result;
        this.usuarioDao = dao;
        this.usuarioLogado = usuarioLogado;
        this.usuarioInfo = usuarioInfo;
     
    }
	
public void autentica (Usuario usuario) {
	result.include("usuario", usuarioDao.procura(usuario)); 
       
	if (usuarioDao.contemUserComLogin(usuario.getLogin(),usuario.getSenha())) {
		usuarioInfo.login(usuario);
		usuarioLogado.efetuaLogin(usuario);
		result.forwardTo(ProdutoController.class).lista();
		return;
 	} else {
	result.redirectTo(LoginController.class).formulario();}
}

public void formulario() {
	
	
}

public void menu() {
	
}

}
