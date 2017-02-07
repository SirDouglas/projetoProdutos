package br.com.caelum.produto.interceptor;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.produto.modelo.Usuario;
import java.io.Serializable;


@SessionScoped
@Named
public class UsuarioInfo implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1751898130289321283L;
	private Usuario usuario;

    public Usuario getUser() {
        return usuario;
    }

    public void login(Usuario usuario) {
        this.usuario = usuario;
    }

    public void logout() {
        this.usuario = null;
    }
}
