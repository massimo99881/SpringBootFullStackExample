package edu.quintainfo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.quintainfo.entities.Author;
import edu.quintainfo.exceptions.AuthorNotFoundException;
import edu.quintainfo.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository repository;

	@Override
	public List<Author> findAllAuthors() {
		return (List<Author>) repository.findAll();
	}

	@Override
	public Author findAuthorById(Integer id) throws AuthorNotFoundException {
		Optional<Author> optAuthor = repository.findById(id);
		if (optAuthor.isPresent()) {
			return optAuthor.get();
		}
		throw new AuthorNotFoundException(id);
	}

	@Override
	public Integer saveAuthor(Author author) {
		return repository.save(author).getId();
	}

}
