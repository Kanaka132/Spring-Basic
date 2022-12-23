package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Book;


public interface BookService {
	Book addBook(Book book) ;
	Book editBook(Book book,long bookId);
	void deleteBook(long bookId) ;
//	List<Book> searchForAbook(String name);
}
