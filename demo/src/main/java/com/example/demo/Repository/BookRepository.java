package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	

	
	

}
