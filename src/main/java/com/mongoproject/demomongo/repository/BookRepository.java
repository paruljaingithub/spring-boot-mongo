package com.mongoproject.demomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongoproject.demomongo.model.Book;


public interface BookRepository extends MongoRepository<Book, Integer>{

}
