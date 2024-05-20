package edu.quintainfo.services;



import java.util.List;

import edu.quintainfo.entities.Book;
import edu.quintainfo.exceptions.BookNotFoundException;

public interface BookService {
	
//	● Ottenere uno specifico book di cui si conosce l’id: findBookById
//	● Ottenere uno specifico book di cui si conosce il titolo: findBookByTitle
//	● Ottenere tutti i book di un dato genere: findBooksByGenre
//	● Ottenere tutti i generi senza ripetizioni: findAllGenres
//	● Creare un libro: saveBook
//	● Cancellare un libro, noto l’id: deleteBookById
//	● Modificare un libro: updateBookById
	
	List<Book> findAllBooks();
	Book findBookById(Integer id) throws BookNotFoundException;
	Book findBookByTitle(String title) throws BookNotFoundException;
	Integer saveBook(Book book);
	void deleteBookById(Integer id) throws BookNotFoundException;

}
