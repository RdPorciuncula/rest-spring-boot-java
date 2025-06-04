package br.com.java.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.java.data.vo.v1.BookVO;
import br.com.java.exceptions.RequiredObjectIsNullException;
import br.com.java.mapper.mocks.MockBook;
import br.com.java.model.Book;
import br.com.java.repositories.BookRepository;
import br.com.java.services.BookService;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
	
	MockBook input;
	
	@InjectMocks
	private BookService service;
	
	@Mock
	BookRepository repository;

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockBook();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<Book> list = input.mockEntityList();
		
		when(repository.findAll()).thenReturn(list);
		
		var book = service.findAll();
		
		assertNotNull(book);
		assertEquals(14, book.size());
		
		var bookOne = book.get(1);
		
		assertNotNull(bookOne);
		assertNotNull(bookOne.getKey());
		assertNotNull(bookOne.getLinks());
		assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		
		assertEquals("Rodrigo1", bookOne.getAuthor());
		assertEquals("Programe-se1", bookOne.getTitle());
		assertEquals(30D, bookOne.getPrice());
		
		var bookFour = book.get(4);
		
		assertNotNull(bookFour);
		assertNotNull(bookFour.getKey());
		assertNotNull(bookFour.getLinks());
		assertTrue(bookFour.toString().contains("links: [</api/book/v1/4>;rel=\"self\"]"));
		assertEquals("Rodrigo4", bookFour.getAuthor());
		assertEquals("Programe-se4", bookFour.getTitle());
		assertEquals(30D, bookFour.getPrice());
		
		var bookSeven = book.get(7);
		
		assertNotNull(bookSeven);
		assertNotNull(bookSeven.getKey());
		assertNotNull(bookSeven.getLinks());
		assertTrue(bookSeven.toString().contains("links: [</api/book/v1/7>;rel=\"self\"]"));
		assertEquals("Rodrigo7", bookSeven.getAuthor());
		assertEquals("Programe-se7", bookSeven.getTitle());
		assertEquals(30D, bookSeven.getPrice());
	}

	@Test
	@DisplayName("Deve testar a busca por um id")
	void testFindById() {
		Book entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		var result = service.findById(1L);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Rodrigo1", result.getAuthor());
		assertEquals("Programe-se1", result.getTitle());
		assertEquals(30D, result.getPrice());
	}

	@Test
	@DisplayName("Deve testar a criação")
	void testCreate() {
		Book entity = input.mockEntity(1);
		
		Book persisted = entity;
		persisted.setId(1L);
		
		BookVO vo = input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.create(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Rodrigo1", result.getAuthor());
		assertEquals("Programe-se1", result.getTitle());
		assertEquals(30D, result.getPrice());
	}
	
	@Test
	@DisplayName("Deve testar a exception RequiredObjctIsNullException lançada pelo método create")
	void testCreateWithNullBook() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.create(null);
		});
		
		String expectedMessage = "Nao e permitido persistir um objeto nulo!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@DisplayName("Deve testar a atuailzação")
	void testUpdate() {
		Book entity = input.mockEntity(1);
		entity.setId(1L);
		
		Book persisted = entity;
		persisted.setId(1L);
		
		BookVO vo = input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.update(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Rodrigo1", result.getAuthor());
		assertEquals("Programe-se1", result.getTitle());
		assertEquals(30D, result.getPrice());
	}
	
	@Test
	@DisplayName("Deve testar a exception RequiredObjctIsNullException lançada pelo método update")
	void testUpdateWithNullBook() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.create(null);
		});
		
		String expectedMessage = "Nao e permitido persistir um objeto nulo!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@DisplayName("Deve testar a exclusão")
	void testDelete() {
		Book entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		service.delete(1L);
	}
}
