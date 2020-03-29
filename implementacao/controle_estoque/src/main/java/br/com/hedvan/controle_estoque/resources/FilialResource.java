package br.com.hedvan.controle_estoque.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/filiais")
public class FilialResource {

	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "REST funcionando";
	}
	
}
