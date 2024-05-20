package edu.quintainfo.exceptions;

public class AuthorNotFoundException extends Exception {

	private static final long serialVersionUID = 2349271741603050153L;
	
	public AuthorNotFoundException(Integer id) {
		super("Author with id " + id + " not found");
	}

}
