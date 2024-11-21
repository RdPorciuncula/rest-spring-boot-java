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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for managing peoples")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	@Operation(summary = "Find all people", description = "Finds all people",
	tags = {"People"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = {
					@Content(
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
							)
			}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})
	public List<PersonVO> findAll() {
		return personService.findAll();
	}
	
	

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, 
											 MediaType.APPLICATION_XML,
											 MediaType.APPLICATION_YML})
	@Operation(summary = "Find one person", description = "Finds one person",
	tags = {"People"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = PersonVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return personService.findById(id);
	}
	
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, 
							 MediaType.APPLICATION_XML,
							 MediaType.APPLICATION_YML},	
				 produces = {MediaType.APPLICATION_JSON, 
						 	 MediaType.APPLICATION_XML,
						 	 MediaType.APPLICATION_YML})
	@Operation(summary = "Create a new person", description = "Create a new person",
	tags = {"People"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = PersonVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return personService.create(person);
	}
	
/*	@PostMapping(value="/v2", consumes = {MediaType.APPLICATION_JSON, 
										  MediaType.APPLICATION_XML,
										  MediaType.APPLICATION_YML},	
			 				  produces = {MediaType.APPLICATION_JSON, 
			 						  	  MediaType.APPLICATION_XML,
			 						  	  MediaType.APPLICATION_YML})
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) throws Exception {
		return personService.createV2(person);
	} */
	
	
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML}, 
				produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	@Operation(summary = "Update a person", description = "Update one person",
	tags = {"People"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = PersonVO.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		return personService.update(person);
	}
	
	
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete a person", description = "Delete a person",
	tags = {"People"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
}