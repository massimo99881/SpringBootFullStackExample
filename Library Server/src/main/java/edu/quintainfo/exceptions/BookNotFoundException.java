package edu.quintainfo.exceptions;

public class BookNotFoundException extends Exception {

	private static final long serialVersionUID = -3653139273872005576L;
	
	public BookNotFoundException(Integer id) {
		super("Book with id " + id + " not found");
	}
	
	public BookNotFoundException(String title) {
		super("Book with title " + title + " not found");
	}

}
