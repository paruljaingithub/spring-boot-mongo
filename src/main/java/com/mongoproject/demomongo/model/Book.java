package com.mongoproject.demomongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "Book")
public class Book {

	@Id
	private int bookId;
	private String bookName;
	public Book(int bookId, String bookName, String autherName) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.autherName = autherName;
	}
	private String autherName;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAutherName() {
		return autherName;
	}
	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", autherName=" + autherName + "]";
	}
	
	
}
