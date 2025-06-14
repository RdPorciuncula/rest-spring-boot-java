package br.com.java.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.java.data.vo.v1.BookVO;
import br.com.java.model.Book;

public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }
    
    public BookVO mockVO() {
        return mockVO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }
    
    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(Long.valueOf(String.valueOf(number)));
        book.setAuthor("Rodrigo" + number);
        book.setLaunchDate(new Date());
        book.setPrice(30D);
        book.setTitle("Programe-se" + number);
        
        return book;
    }

    public BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setKey(Long.valueOf(String.valueOf(number)));
        book.setAuthor("Rodrigo" + number);
        book.setLaunchDate(new Date());
        book.setPrice(30D);
        book.setTitle("Programe-se" + number);
        return book;
    }

}
