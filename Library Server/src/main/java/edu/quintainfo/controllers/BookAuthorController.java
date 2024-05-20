package edu.quintainfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.quintainfo.dtos.BookAuthorDto;
import edu.quintainfo.entities.Author;
import edu.quintainfo.entities.Book;
import edu.quintainfo.exceptions.AuthorNotFoundException;
import edu.quintainfo.services.AuthorService;
import edu.quintainfo.services.BookService;

@RestController
@RequestMapping ("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BookAuthorController {
	
	@Autowired 
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/add-book")
	public ResponseEntity<?> addBook(@RequestBody BookAuthorDto bookAuthorDto) {
		try {
			Integer authorId = bookAuthorDto.getAuthorId();
			System.err.println(authorId);
			Author author = authorService.findAuthorById(authorId);
			Book book = new Book();
			book.setTitle(bookAuthorDto.getTitle());
			book.setGenre(bookAuthorDto.getGenre());
			book.setPrice(bookAuthorDto.getPrice());
			book.addAuthor(author);
			System.err.println(book);
			Integer idBook = bookService.saveBook(book);
			return new ResponseEntity<>("Book with id " + idBook + " saved", HttpStatus.OK);	
		} catch(AuthorNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
