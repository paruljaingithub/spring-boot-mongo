package com.mongoproject.demomongo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongoproject.demomongo.model.Book;
import com.mongoproject.demomongo.repository.BookRepository;
import com.mongoproject.demomongo.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DemomongoApplicationTests {

	@Autowired
	private BookService service; 
	
	
	
	
	@MockBean // it mean its not hitting the database it will return the mock data
	private BookRepository repository;
	
	@Test
	public void getAllBookTest() {
		
		when(repository.findAll()).thenReturn(Stream.of(new Book(101, "c", "john"), new Book(102,"cpp", "william")).collect(Collectors.toList()));
		assertEquals(2, service.getBooks().size());
		
	}
	
	@Test
	public void saveBookTest() {
		//Book book = new Book(101, "c");
	}

}
