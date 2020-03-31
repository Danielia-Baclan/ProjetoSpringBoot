package br.edu.up.casa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.up.casa.entity.Casa;

public interface CasaRepository extends JpaRepository<Casa, Integer> {

}