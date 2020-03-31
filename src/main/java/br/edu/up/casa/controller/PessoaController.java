package br.edu.up.casa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.casa.entity.Pessoa;
import br.edu.up.casa.repository.PessoaRepository;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Pessoa> listAll(){
		Iterable<Pessoa> list = repository.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Pessoa getById(@PathVariable Integer id) {
		Pessoa entity = repository.getOne(id);
		return entity;
	}
	
	@PostMapping
	public Pessoa add(@RequestBody @Valid Pessoa entity) {
		return repository.save(entity);
	}
	
	@DeleteMapping("/{id}")
	public Pessoa delete(@PathVariable Integer id) {
		Pessoa entity = repository.getOne(id);
		repository.delete(entity);
		return entity;
	}
}
