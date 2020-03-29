package br.com.hedvan.controle_estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hedvan.controle_estoque.domain.Filial;
import br.com.hedvan.controle_estoque.repositories.FilialRepository;

@Service
public class FilialService {

	@Autowired
	private FilialRepository filialRepository;
	
	public Filial findById(Integer id) {
		Optional<Filial> result = filialRepository.findById(id);
		return result.orElse(null);
	}
	
	public List<Filial> findAll(){
		return filialRepository.findAll();
	}
	
}
