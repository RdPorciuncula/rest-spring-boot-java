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
import br.com.java.data.vo.v2.PersonVOV2;
import br.com.java.services.PersonService;
import br.com.java.util.MediaType;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	public List<PersonVO> findAll() {
		return personService.findAll();
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, 
											 MediaType.APPLICATION_XML,
											 MediaType.APPLICATION_YML})
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return personService.findById(id);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, 
							 MediaType.APPLICATION_XML,
							 MediaType.APPLICATION_YML},	
				 produces = {MediaType.APPLICATION_JSON, 
						 	 MediaType.APPLICATION_XML,
						 	 MediaType.APPLICATION_YML})
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return personService.create(person);
	}
	
	@PostMapping(value="/v2", consumes = {MediaType.APPLICATION_JSON, 
										  MediaType.APPLICATION_XML,
										  MediaType.APPLICATION_YML},	
			 				  produces = {MediaType.APPLICATION_JSON, 
			 						  	  MediaType.APPLICATION_XML,
			 						  	  MediaType.APPLICATION_YML})
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) throws Exception {
		return personService.createV2(person);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML}, 
				produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		return personService.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
}