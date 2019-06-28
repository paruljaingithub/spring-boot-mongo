package com.mongoproject.demomongo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongoproject.demomongo.model.Book;
import com.mongoproject.demomongo.repository.BookRepository;

@RunWith(SpringRunner.class)
public class BookServiceTest {

	@Mock // mock bean will add bean to the spring application context where as @mock will not add into the spring application context
	private BookRepository repository;
	
	 @Autowired
	 ApplicationContext context;
	 
	/* @Before
	 public void setup() {
		 
		  MockitoAnnotations.initMocks(this);
		  System.out.println(repository.count());
	 }*/
	
	@Test
	public void getAllBookTest() {
		
		
		System.out.println(repository.count());
		when(repository.findAll()).thenReturn(Stream.of(new Book(101, "c", "john"), new Book(102,"cpp", "william")).collect(Collectors.toList()));
		//BookRepository userRepoFromContext = context.getBean(BookRepository.class);
		//long userCount = userRepoFromContext.findAll().size();
		//System.out.println("userCount:::::::"+ userCount);
		assertEquals(2, repository.findAll().size());
		
	}
}
