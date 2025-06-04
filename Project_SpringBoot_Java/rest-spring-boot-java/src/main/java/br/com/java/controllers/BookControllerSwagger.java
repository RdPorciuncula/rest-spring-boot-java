package br.com.java.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.java.data.vo.v1.BookVO;
import br.com.java.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface BookControllerSwagger {

	@Operation(summary = "Find All Book", description = "Finds All Book",
			tags = {"Book"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
						content = {
							@Content(
									mediaType = MediaType.APPLICATION_JSON,
									array = @ArraySchema(schema = @Schema(implementation = BookVO.class))
									)
					}),
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	List<BookVO> findAll();
	
	@Operation(summary = "Find one book", description = "Finds one book",
			tags = {"Book"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
						content = @Content(schema = @Schema(implementation = BookVO.class))),
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	BookVO findById(Long id) throws Exception;
	
	@Operation(summary = "Create a new book", description = "Create a new book",
			tags = {"Book"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
						content = @Content(schema = @Schema(implementation = BookVO.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	BookVO create(BookVO book) throws Exception;
	
	@Operation(summary = "Update a book", description = "Update one book",
			tags = {"Book"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
						content = @Content(schema = @Schema(implementation = BookVO.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	BookVO update(BookVO book) throws Exception;

	@Operation(summary = "Delete a book", description = "Delete a book",
			tags = {"Book"},
			responses = {
					@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
			})
	ResponseEntity<?> delete(Long id) throws Exception;

}