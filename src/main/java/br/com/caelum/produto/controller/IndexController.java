package br.com.caelum.produto.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {
      

	private  Result result;
	
	
	/**
	 * @deprecated CDI eyes only
	 */
	public IndexController() {
		this(null);
	}
	
	@Inject
	public  IndexController(Result result) {
		 this.result = result;
	}
	
	@Path("/")
	public void index() {
		result.include("variable", "VRaptor!");
	}
}
