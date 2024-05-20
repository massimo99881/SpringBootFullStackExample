package edu.quintainfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import edu.quintainfo.entities.Book;
import edu.quintainfo.exceptions.BookNotFoundException;
import edu.quintainfo.services.BookService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BookController {
	
	@Autowired
	private BookService service;
	
//	@GetMapping("/books")
//	public List<Book> findAllBooks(){
//		return service.findAllBooks();
//	}
	
	@GetMapping("/books")
	public ResponseEntity<?> findAllBooks(){
		 List<Book> books = service.findAllBooks();
		 if (!books.isEmpty()) {
			 return new ResponseEntity<>(books, HttpStatus.OK);
		 } else {
			 return new ResponseEntity<>("No books found", HttpStatus.NOT_FOUND);
		 }
	}
	
//	@GetMapping("/books/{id}") 
//	public Book findBookById(@PathVariable Integer id ) {
//		Book book = null;
//		try {
//			book = service.findBookById(id);
//		} catch (BookNotFoundException e) {
//			e.printStackTrace();
//		}
//		return book;
//	}
	
	@GetMapping("/books/{id}") 
	public ResponseEntity<?> findBookById(@PathVariable Integer id ) {
		try {
			return new ResponseEntity<>(service.findBookById(id), HttpStatus.OK);
		} catch (BookNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
//	@GetMapping("/books/by-title/{title}") 
//	public Book findBookByTitle(@PathVariable String title) {
//		Book book = null;
//		try {
//			book = service.findBookByTitle(title);
//		} catch (BookNotFoundException e) {
//			e.printStackTrace();
//		}
//		return book;
//	}
	
	@GetMapping("/books/by-title/{title}") 
	public ResponseEntity<?> findBookByTitle(@PathVariable String title) {
		Book book = null;
		try {
			book = service.findBookByTitle(title);
			return new ResponseEntity<>(book, HttpStatus.OK);
		} catch (BookNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
//	@PostMapping("/books/admin")
//	public Integer saveBook(@RequestBody Book book) {
//		return service.saveBook(book);
//	}
	
	@PostMapping("/books/admin")
	public ResponseEntity<Integer> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(service.saveBook(book), HttpStatus.OK);
	}
	
//	@DeleteMapping("/books/admin/{id}")
//	public void deleteBookById(@PathVariable Integer id) {
//		try {
//			service.deleteBookById(id);		
//		} catch (BookNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	@DeleteMapping("/books/admin/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer id) {
		try {
			service.deleteBookById(id);	
			return new ResponseEntity<>("Book with id " + id + " deleted", HttpStatus.OK);	
		} catch (BookNotFoundException e) {
			return new ResponseEntity<>("Book with id " + id + " not exists", HttpStatus.NOT_FOUND);
		}
	}
	

}
