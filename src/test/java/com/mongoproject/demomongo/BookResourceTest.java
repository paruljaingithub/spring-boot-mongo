package com.mongoproject.demomongo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongoproject.demomongo.model.Book;
import com.mongoproject.demomongo.resource.BookResource;
import com.mongoproject.demomongo.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookResource.class, secure = false)
public class BookResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService service;

	@Test
	public void testGetAllBookTest() throws Exception {
		when(service.getBooks()).thenReturn(Stream.of(new Book(101, "c", "john")).collect(Collectors.toList()));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getallbook").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		List<Book> list = new ArrayList<>();
		list.add(new Book(101, "c", "john"));
		list.add(new Book(102,"cpp", "william"));
		
		String[] str = new String[2];
		str[0] = "{bookId:101,bookName:c,autherName:john}";
		str[1] = "{bookId:102,bookName:cpp,autherName:william}";
		System.out.println("String array:::"+ str);
		JSONAssert.assertEquals(str[0], result.getResponse()
				.getContentAsString().replace("[", "").replace("[", ""), false);
	}
	
	@Test
	public void testSaveBook() throws Exception {
		Book book = new Book(101, "c", "john");
		 ObjectMapper Obj = new ObjectMapper(); 
		 String jsonStr = Obj.writeValueAsString(book); 
		 System.out.println("jsonStr::::"+jsonStr);
		when(service.saveBook(Mockito.any(Book.class))).thenReturn(book);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addbook").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonStr);
		//MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		//MockHttpServletResponse response = result.getResponse();
        System.out.println("HttpStatus.CREATED.value():::"+ HttpStatus.CREATED.value());
		//System.out.println("response.getStatus():::"+ response);
		
		//assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
}
