package br.com.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.java.data.vo.v1.PersonVO;
import br.com.java.services.PersonService;
import br.com.java.util.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
public class PersonController implements PersonControllerSwagger {
	
	@Autowired
	private PersonService personService;
	
	@Override
	@GetMapping(produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	
	public List<PersonVO> findAll() {
		return personService.findAll();
	}
	
	@Override
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, 
											 MediaType.APPLICATION_XML,
											 MediaType.APPLICATION_YML})
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return personService.findById(id);
	}
	
	@Override
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, 
							 MediaType.APPLICATION_XML,
							 MediaType.APPLICATION_YML},	
				 produces = {MediaType.APPLICATION_JSON, 
						 	 MediaType.APPLICATION_XML,
						 	 MediaType.APPLICATION_YML})
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return personService.create(person);
	}
		
	@Override
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML}, 
				produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		return personService.update(person);
	}
	
	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
}