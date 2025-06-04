package br.com.java.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.java.data.vo.v1.PersonVO;
import br.com.java.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface PersonControllerSwagger {

	@Operation(summary = "Find All People", description = "Finds All People",
			tags = {"People"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
						content = {
							@Content(
									mediaType = MediaType.APPLICATION_JSON,
									array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
									)
					}),
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	List<PersonVO> findAll();
	
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
	PersonVO findById(Long id) throws Exception;
	
	@Operation(summary = "Create a new person", description = "Create a new person",
			tags = {"People"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
						content = @Content(schema = @Schema(implementation = PersonVO.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	PersonVO create(PersonVO person) throws Exception;
	
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
	PersonVO update(PersonVO person) throws Exception;

	@Operation(summary = "Delete a person", description = "Delete a person",
			tags = {"People"},
			responses = {
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	ResponseEntity<?> delete(Long id) throws Exception;

}