package com.ibm.deeps.deepsgraphqlbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.deeps.deepsgraphqlbackend.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
	

}
