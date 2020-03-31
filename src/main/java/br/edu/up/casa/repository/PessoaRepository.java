package br.edu.up.casa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.up.casa.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}