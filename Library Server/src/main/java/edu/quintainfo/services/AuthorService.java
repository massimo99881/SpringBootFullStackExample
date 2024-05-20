package edu.quintainfo.services;

import java.util.List;

import edu.quintainfo.entities.Author;
import edu.quintainfo.exceptions.AuthorNotFoundException;

public interface AuthorService {

	List<Author> findAllAuthors();
	Author findAuthorById(Integer id) throws AuthorNotFoundException;
	Integer saveAuthor(Author author);

}
