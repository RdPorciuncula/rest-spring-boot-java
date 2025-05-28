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

import br.com.java.data.vo.v1.BookVO;
import br.com.java.services.BookService;
import br.com.java.util.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "Endpoints for Managing Books")
public class BookController implements BookControllerSwagger {
	
	@Autowired
	private BookService bookService;
	
	@Override
	@GetMapping(produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	
	public List<BookVO> findAll() {
		return bookService.findAll();
	}
	
	@Override
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, 
											 MediaType.APPLICATION_XML,
											 MediaType.APPLICATION_YML})
	public BookVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return bookService.findById(id);
	}
	
	@Override
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, 
							 MediaType.APPLICATION_XML,
							 MediaType.APPLICATION_YML},	
				 produces = {MediaType.APPLICATION_JSON, 
						 	 MediaType.APPLICATION_XML,
						 	 MediaType.APPLICATION_YML})
	public BookVO create(@RequestBody BookVO book) throws Exception {
		return bookService.create(book);
	}
		
	@Override
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML}, 
				produces = {MediaType.APPLICATION_JSON, 
							MediaType.APPLICATION_XML,
							MediaType.APPLICATION_YML})
	public BookVO update(@RequestBody BookVO book) throws Exception {
		return bookService.update(book);
	}
	
	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}
}