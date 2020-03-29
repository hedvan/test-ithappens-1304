package br.com.hedvan.controle_estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hedvan.controle_estoque.domain.Usuario;
import br.com.hedvan.controle_estoque.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> result = usuarioRepository.findById(id);
		return result.orElse(null);
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
}
