package br.com.caelum.produto.component;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.produto.dao.UsuarioDao;
import br.com.caelum.produto.modelo.Usuario;




public class UsuarioLogado implements  ConstraintValidator<LoginAvailable, Usuario> {

	


	@Inject
	private Usuario usuarioLogado;
	
	@Inject
	private UsuarioDao dao;
	
	public void efetuaLogin(Usuario usuario) {
		this.usuarioLogado = usuario;
	}
	
	public Usuario getUsuario() {
		return this.usuarioLogado;
	}

	
	@Override
	public void initialize(LoginAvailable arg0) {
		// TODO Auto-generated method stub
		
	}



	   @Override
	    public boolean isValid(Usuario usuario, ConstraintValidatorContext context) {
	        return !dao.contemUserComLogin(usuario.getLogin(),usuario.getSenha());
	        		
	    }

	
}
