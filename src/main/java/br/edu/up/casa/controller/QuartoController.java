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

import br.edu.up.casa.entity.Quarto;
import br.edu.up.casa.repository.QuartoRepository;

@RestController
@RequestMapping("quarto")
public class QuartoController {

	@Autowired
	private QuartoRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Quarto> listAll(){
		Iterable<Quarto> list = repository.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Quarto getById(@PathVariable Integer id) {
		Quarto entity = repository.getOne(id);
		return entity;
	}
	
	@PostMapping
	public Quarto add(@RequestBody @Valid Quarto entity) {
		return repository.save(entity);
	}
	
	@DeleteMapping("/{id}")
	public Quarto delete(@PathVariable Integer id) {
		Quarto entity = repository.getOne(id);
		repository.delete(entity);
		return entity;
	}
}
