package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.BookHistory;

@Repository
public interface BookHistoryRepository  extends JpaRepository<BookHistory, Long>{

	
}
