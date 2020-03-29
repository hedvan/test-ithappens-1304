package br.com.hedvan.controle_estoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hedvan.controle_estoque.domain.Produto;
import br.com.hedvan.controle_estoque.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Produto obj = produtoService.findById(id);
		if (obj != null)
			return ResponseEntity.ok(obj);
		else
			return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> list() {
		return ResponseEntity.ok(produtoService.findAll());
	}
	
}
