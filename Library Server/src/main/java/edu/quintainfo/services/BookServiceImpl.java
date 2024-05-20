package edu.quintainfo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.quintainfo.entities.Book;
import edu.quintainfo.exceptions.BookNotFoundException;
import edu.quintainfo.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired 
	private BookRepository repository;
	
	@Override
	public List<Book> findAllBooks() {
		Iterable<Book> books = repository.findAll();
		return (List<Book>) books;
		// return (List<Book>) repository.findAll();
	}

	@Override
	public Book findBookById(Integer id) throws BookNotFoundException {
		Optional<Book> optBook = repository.findById(id);
		if (optBook.isPresent()) {
			return optBook.get();
		}
		throw new BookNotFoundException(id);
	}

	@Override
	public Book findBookByTitle(String title) throws BookNotFoundException {
		Optional<Book> optBook = repository.findByTitle(title);
		if (optBook.isPresent()) {
			return optBook.get();
		}
		throw new BookNotFoundException(title);
	}

	@Override
	public Integer saveBook(Book book) {
		Book savedBook = repository.save(book);
		return savedBook.getId();
	}

	@Override
	public void deleteBookById(Integer id) throws BookNotFoundException {
		Optional<Book> optBook = repository.findById(id);
		if (optBook.isPresent()) {
			repository.deleteById(id);
		}
		throw new BookNotFoundException(id);
		
	}

}
