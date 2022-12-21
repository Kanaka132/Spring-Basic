package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.Book;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Service.BookService;




@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book addBook(Book book)  {
		Book newBook = bookRepository.save(book);
		return newBook;
	}

	
	@Override
	public Book editBook(Book book, long bookId) {
		        Book existingBook = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book not found with clinic Id: " + bookId ));
		        existingBook.setBookName(book.getBookName());
		        existingBook.setBookDesc(book.getBookDesc());
		        existingBook.setBookQuantity(book.getBookQuantity());
		        //Saving updated book details in database 
		        bookRepository.save(existingBook);
		        return existingBook;
	}

	@Override
	public void deleteBook(long bookId) {
		 Book book = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book not found with book Id: " + bookId ));
	        bookRepository.deleteById(book.getBookId());
	}


	@Override
	public List<Book> searchForAbook(String name) {
		// TODO Auto-generated method stub
		 List<Book> books = bookRepository.searchForAbook(name);
	        if(books.isEmpty()){
	            throw new ResourceNotFoundException("Books not found");
	        }
	        return books;
	}

}
