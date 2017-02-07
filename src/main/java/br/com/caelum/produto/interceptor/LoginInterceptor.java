package br.com.caelum.produto.interceptor;

import static java.util.Arrays.asList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.produto.component.UsuarioLogado;
import br.com.caelum.produto.controller.LoginController;
import br.com.caelum.produto.dao.UsuarioDao;
import br.com.caelum.produto.modelo.Usuario;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.BeanClass;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.validator.SimpleMessage;


@Intercepts
@RequestScoped
@Named
public class LoginInterceptor {
	
	  
	  @Inject
	private UsuarioLogado usuarioLogado;
	
	  
	  @Inject
	private Result result;
	  
	  @Inject
	private HttpServletResponse response; 
	  
	  @Inject
	private UsuarioDao dao;
	
	  
	  @Inject
	private UsuarioInfo usuarioInfo;
	


	


		@Accepts
		public boolean accepts(ControllerMethod method) {
		      BeanClass controller = method.getController();
 return !controller.getType().isAssignableFrom(LoginController.class); 
			
		}

	
		@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
			Usuario current = usuarioInfo.getUser(); 
			 	try {
				dao.refresh(current);
			} catch (Exception e) {
				
			}

		
			if (current == null) {
				// remember added parameters will survive one more request, when there is a redirect
				result.include("errors", asList(new SimpleMessage("usuario", "usuario não está logado")));
				result.redirectTo(LoginController.class).formulario();
				return;
			}
			stack.next(); 
			
			//result.redirectTo(LoginController.class).formulario();
			
	}
		
		
	

}
