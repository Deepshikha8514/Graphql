package com.ibm.deeps.deepsgraphqlbackend.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class BookDTO implements Serializable{
	private String isbn;
	private String title;
	private List<AuthorDTO> authors = new ArrayList<>();
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<AuthorDTO> getAuthors() {
		return authors;
	}
	public void setAuthor(List<AuthorDTO> authors) {
		this.authors = authors;
	}
	
	public Book toEntity() {
		Book bookentity = new Book();
		bookentity.setIsbn(this.isbn);
		bookentity.setTitle(this.title);
		return bookentity;
	}
}
