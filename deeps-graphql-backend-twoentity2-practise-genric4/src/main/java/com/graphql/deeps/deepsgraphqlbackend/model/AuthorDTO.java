package com.ibm.deeps.deepsgraphqlbackend.model;

import java.util.ArrayList;
import java.util.List;


public class AuthorDTO {
	private String id;
	private String name;
	
	private List<BookDTO> books = new ArrayList<BookDTO>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<BookDTO> getBooks() {
		return books;
	}
	
	
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
	public Author toEntity() {
		Author authorentity = new Author();
		authorentity.setId(this.getId());
		authorentity.setName(this.getName());
		return authorentity;
	}
}
