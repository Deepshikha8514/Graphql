package com.ibm.deeps.deepsgraphqlbackend.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.deeps.deepsgraphqlbackend.model.Author;
import com.ibm.deeps.deepsgraphqlbackend.model.AuthorDTO;
import com.ibm.deeps.deepsgraphqlbackend.model.Book;
import com.ibm.deeps.deepsgraphqlbackend.model.BookDTO;
import com.ibm.deeps.deepsgraphqlbackend.repository.AuthorRepository;
//import com.ibm.deeps.deepsgraphqlbackend.model.BookWrapper;
import com.ibm.deeps.deepsgraphqlbackend.repository.BookRepository;
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookResolver implements GraphQLQueryResolver {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
    @Autowired
    public BookResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        BufferedReader bufferedReader = null;

    }
   
   public List <AuthorDTO>  getAllAuthors() {
       	List<Author> author = authorRepository.findAll();
       	List<AuthorDTO> authordto = new ArrayList<AuthorDTO>();
       	for(Author auth : author)
       	{
       		AuthorDTO authdto = auth.toDTO();
       		authordto.add(authdto);
       		for(Book book : auth.getBooks()) {
       			authdto.getBooks().add(book.toDTO());
       		}
       		System.out.println(auth.getBooks().size());
       	}
       	return authordto;
    }
   
   public List <BookDTO>  getAllBooks() {
   	List<Book> book = bookRepository.findAll();
   	List<BookDTO> bookdto = new ArrayList<BookDTO>();
   	for(Book buk : book)
   	{
   		BookDTO bukdto = buk.toDTO();
   		bookdto.add(bukdto);
   		for(Author auth : buk.getAuthors()) {
   			bukdto.getAuthors().add(auth.toDTO());
   		}
   		System.out.println(buk.getAuthors().size());
   	}
   	return bookdto;
}
}
