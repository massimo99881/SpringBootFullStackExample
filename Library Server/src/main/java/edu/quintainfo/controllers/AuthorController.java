package edu.quintainfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.quintainfo.entities.Author;
import edu.quintainfo.exceptions.AuthorNotFoundException;
import edu.quintainfo.services.AuthorService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
//	@GetMapping("/authors")
//	public List<Author> findAllAuthors(){
//		return service.findAllAuthors();
//	}
	
	@GetMapping("/authors")
	public ResponseEntity<?> findAllAuthors(){
		List<Author> authors = service.findAllAuthors();
		if (!authors.isEmpty()) {
			return new ResponseEntity<>(authors, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No authors found", HttpStatus.NOT_FOUND);	
		}
	}
	
//	@GetMapping("/authors/{id}") 
//	public Author findAuthorById(@PathVariable Integer id ) {
//		Author author = null;
//		try {
//			author = service.findAuthorById(id);
//		} catch (AuthorNotFoundException e) {
//			e.printStackTrace();
//		}
//		return author;
//	}
	
	@GetMapping("/authors/{id}") 
	public ResponseEntity<?> findAuthorById(@PathVariable Integer id ) {
		try {
			return new ResponseEntity<>(service.findAuthorById(id), HttpStatus.OK);
		} catch (AuthorNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
//	@PostMapping("/authors/admin")
//	public Integer saveAuthor(@RequestBody Author author) {
//		return service.saveAuthor(author);
//	}
	
	@PostMapping("/authors/admin")
	public ResponseEntity<Integer> saveAuthor(@RequestBody Author author) {
		return new ResponseEntity<>(service.saveAuthor(author), HttpStatus.OK);
	}

}
