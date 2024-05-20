package edu.quintainfo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.quintainfo.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	Optional<Book> findByTitle(String title);
}
