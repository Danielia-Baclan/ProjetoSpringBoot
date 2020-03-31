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

import br.edu.up.casa.entity.Casa;
import br.edu.up.casa.repository.CasaRepository;

@RestController
@RequestMapping("casa")
public class CasaController {

	@Autowired
	private CasaRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Casa> listAll(){
		Iterable<Casa> list = repository.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Casa getById(@PathVariable Integer id) {
		Casa casa = repository.getOne(id);
		return casa;
	}
	
	@PostMapping
	public Casa add(@RequestBody @Valid Casa casa) {
		return repository.save(casa);
	}
	
	@DeleteMapping("/{id}")
	public Casa delete(@PathVariable Integer id) {
		Casa casa = repository.getOne(id);
		repository.delete(casa);
		return casa;
	}
}