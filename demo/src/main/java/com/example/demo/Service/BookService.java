package com.example.demo.Service;

import com.example.demo.Entities.Book;
import com.example.demo.Exception.ResourceNotFoundException;

public interface BookService {
	Book addBook(Book book) ;
	Book editBook(Book book,long bookId);
	void deleteBook(long bookId) ;

}
