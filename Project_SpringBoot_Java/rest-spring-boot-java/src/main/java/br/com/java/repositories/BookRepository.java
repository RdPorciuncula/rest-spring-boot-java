package br.com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}