package br.com.hedvan.controle_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hedvan.controle_estoque.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
