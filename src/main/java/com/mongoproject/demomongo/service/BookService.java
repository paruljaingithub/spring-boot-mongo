package com.mongoproject.demomongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoproject.demomongo.model.Book;
import com.mongoproject.demomongo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public Book saveBook(Book book) {
		return repository.save(book);
	 }
	
	public List<Book> getBooks() {
	
		return repository.findAll();
	}
	
    public Optional<Book> getBookById(int bookId) {
		
		return repository.findById(bookId);
	}
    
    
    public void deleteBook(int bookId) {
    	repository.deleteById(bookId);
    }
}
