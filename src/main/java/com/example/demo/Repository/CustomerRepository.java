package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Book;
import com.example.demo.Entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "select b from Book b where b.bookName = :name")
    List<Book> searchForAbook(String name);

}
