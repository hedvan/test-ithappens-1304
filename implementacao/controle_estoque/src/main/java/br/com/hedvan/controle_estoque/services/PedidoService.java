package br.com.hedvan.controle_estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hedvan.controle_estoque.domain.Pedido;
import br.com.hedvan.controle_estoque.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido findById(Integer id) {
		Optional<Pedido> result = pedidoRepository.findById(id);
		return result.orElse(null);
	}
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
}
