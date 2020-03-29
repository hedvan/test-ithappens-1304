package br.com.hedvan.controle_estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hedvan.controle_estoque.domain.Produto;
import br.com.hedvan.controle_estoque.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto findById(Integer id) {
		Optional<Produto> result = produtoRepository.findById(id);
		return result.orElse(null);
	}
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
}
