package com.mongoproject.demomongo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongoproject.demomongo.model.Book;
import com.mongoproject.demomongo.repository.BookRepository;
import com.mongoproject.demomongo.service.BookService;

@RestController
public class BookResource {


	@Autowired
	private BookService service;
	
	

	
	@PostMapping("/addbook")
	public Book saveBook(@RequestBody Book book) {
		
		return service.saveBook(book);
		 
		
	}
	
	@GetMapping("/getallbook")
	public List<Book> getBook() {
		
		return service.getBooks();
	}
	
	@GetMapping("/findbookbyid/{bookId}")
	public Optional<Book> getBookById(@PathVariable("bookId") int bookId) {
		
		return service.getBookById(bookId);
	}
}
