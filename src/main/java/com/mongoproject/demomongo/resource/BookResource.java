package com.mongoproject.demomongo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongoproject.demomongo.model.Book;
import com.mongoproject.demomongo.repository.BookRepository;

@RestController
public class BookResource {

	@Autowired
	private BookRepository repository;
	
	@PostMapping("/addbook")
	public boolean saveBook(@RequestBody Book book) {
		 System.out.println("book:::"+book);
		 repository.save(book);
		 return true;
		
	}
	
	@GetMapping("/getallbook")
	public List<Book> getBook() {
		
		return repository.findAll();
	}
	
	@GetMapping("/findbookbyid/{bookId}")
	public Optional<Book> getBookById(@PathVariable("bookId") int bookId) {
		
		return repository.findById(bookId);
	}
}
