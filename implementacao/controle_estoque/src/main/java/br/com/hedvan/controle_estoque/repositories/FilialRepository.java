package br.com.hedvan.controle_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hedvan.controle_estoque.domain.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Integer>{

}
