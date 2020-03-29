package br.com.hedvan.controle_estoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hedvan.controle_estoque.domain.Filial;
import br.com.hedvan.controle_estoque.services.FilialService;

@RestController
@RequestMapping(value="/filiais")
public class FilialResource {
	
	@Autowired
	private FilialService filialService;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Filial obj = filialService.findById(id);
		if (obj != null)
			return ResponseEntity.ok(obj);
		else
			return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(value="/{id}/produtos",method=RequestMethod.GET)
	public ResponseEntity<?> listProducts(@PathVariable Integer id) {
		Filial obj = filialService.findById(id);
		if (obj != null)
			return ResponseEntity.ok(obj.getProdutos());
		else
			return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> list() {
		return ResponseEntity.ok(filialService.findAll());
	}
	
	
}
