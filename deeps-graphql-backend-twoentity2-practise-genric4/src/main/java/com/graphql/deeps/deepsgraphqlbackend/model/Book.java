package com.ibm.deeps.deepsgraphqlbackend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Book implements Serializable{
    private String title;
  
    @Id
    private String isbn;
    
  /*  @ManyToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	
    @JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "isbn") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	@JsonProperty("Author")
	@JsonBackReference
	private List<Author> user = new ArrayList<Author>();

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )*/
    @ManyToMany(fetch = FetchType.EAGER)
   
    private List<Author> authors;
  

public Book() {
	super();
}


public Book(String isbn, String title) {
	super();
	this.isbn = isbn;
	this.title = title;
	
	// TODO Auto-generated constructor stub
}

public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getIsbn() {
	return isbn;
}


public void setIsbn(String isbn) {
	this.isbn = isbn;
}


public List<Author> getAuthors() {
	return authors;
}


public void setAuthors(List<Author> authors) {
	this.authors = authors;
}
public BookDTO toDTO() {
	BookDTO dto = new BookDTO();
	dto.setIsbn(this.isbn);
	dto.setTitle(this.getTitle());
	
	return dto;
}
 
}
