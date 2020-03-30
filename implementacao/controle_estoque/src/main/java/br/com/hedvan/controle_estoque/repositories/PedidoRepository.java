package br.com.hedvan.controle_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hedvan.controle_estoque.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
