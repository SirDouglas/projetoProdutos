package br.com.caelum.produto.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;

import br.com.caelum.produto.modelo.Usuario;


@RequestScoped
public class UsuarioDao {
	
	@Inject
	private EntityManager manager;
	
	
	

	public UsuarioDao() {
		
	}
	
	public void refresh(Usuario usuario) {
		getSession().refresh(usuario); // You still can use Hibernate Session
	}
	
	public Usuario procura(Usuario usuario1) {
		try {
	Usuario usuario = manager.createQuery("select u from Usuario u where u.login= :login and u.senha = :senha",Usuario.class)
				.setParameter("login", usuario1.getLogin())
				.setParameter("senha", usuario1.getSenha())
				.getSingleResult();
		return usuario;
		}
		catch (NoResultException e) {
			
			return null;
		}
	
	}
	
	public boolean contemUserComLogin(String login,String senha) {
		Long count = manager
				.createQuery("select count(u) from Usuario u where u.login= :login and u.senha= :senha", Long.class)
				.setParameter("login", login)
				.setParameter("senha", senha)
				.getSingleResult();
		return count > 0;
	}
	
	private Session getSession() {
		return manager.unwrap(Session.class);
	}
}
