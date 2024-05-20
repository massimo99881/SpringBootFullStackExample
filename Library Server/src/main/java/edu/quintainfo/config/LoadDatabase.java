package edu.quintainfo.config;

import java.math.BigDecimal;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.quintainfo.entities.Author;
import edu.quintainfo.entities.Book;
import edu.quintainfo.repositories.AuthorRepository;
import edu.quintainfo.repositories.BookRepository;

@Configuration
class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	private boolean databaseInitialized = false;
	
	@Bean
	CommandLineRunner initDatabase(BookRepository bookRepository, AuthorRepository authorRepository) {
		return args -> {
			if (!databaseInitialized) {
				// Inizializzazione authors
				Author calvino = new Author("Italo", "Calvino",
						Date.valueOf("1923-10-15"), Date.valueOf("1985-09-19"));
				Author asimov = new Author("Isaac", "Asimov",
						Date.valueOf("1920-01-02"), Date.valueOf("1992-04-06"));
				Author herbert = new Author("Frank", "Herbert",
						Date.valueOf("1920-10-08"), Date.valueOf("1986-02-11"));
				Author king = new Author("Stephen", "King",
						Date.valueOf("1947-09-21"));
				log.info("Preloading " + authorRepository.save(calvino));
				log.info("Preloading " + authorRepository.save(asimov));
				log.info("Preloading " + authorRepository.save(herbert));
				log.info("Preloading " + authorRepository.save(king));
				
				//Inizializzazione books
				Book robot = new Book("Io Robot", "Fantascienza", new
						BigDecimal("11.90"));
				robot.addAuthor(asimov);
				Book dune = new Book("Dune", "Fantascienza", new
						BigDecimal("17.11"));
				dune.addAuthor(herbert);
				Book holly = new Book("Holly", "Horror", new
						BigDecimal("20.80"));
				holly.addAuthor(king);
				log.info("Preloading " + bookRepository.save(robot));
				log.info("Preloading " + bookRepository.save(dune));
				log.info("Preloading " + bookRepository.save(holly));
			
				databaseInitialized = true;
			} else {
				log.info("Il database è già stato inizializzato.");
			}
		};
	}
}