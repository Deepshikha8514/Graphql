package com.ibm.deeps.deepsgraphqlbackend.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author implements Serializable	 {
    @Id
    private String id;
    private String name;
    
@ManyToMany(fetch = FetchType.EAGER)
   private List<Book> books;
   
    public Author()
    {
    	super();
    }
    public Author(String id,String name) {
        this.id = id;
    	this.name = name;
    }

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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public AuthorDTO toDTO() {
		AuthorDTO audto = new AuthorDTO();
		audto.setId(this.id);
		audto.setName(this.getName());
	
		
		return audto;
	}
}

    