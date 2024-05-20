package edu.quintainfo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.quintainfo.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
