package com.ibm.deeps.deepsgraphqlbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.deeps.deepsgraphqlbackend.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

}