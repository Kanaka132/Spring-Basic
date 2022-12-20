package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entities.Book;
import com.example.demo.Exception.ApiResponse;
import com.example.demo.Service.BookService;


@RestController
@RequestMapping("/book")
public class BookController<Public> {


	@Autowired
	private  BookService service;

	
	  @PostMapping("/new/book")	   
	    public ResponseEntity<?> post(@RequestBody Book book){
	        return new ResponseEntity<>(service.addBook(book), HttpStatus.CREATED);
	    }
	  
	  @PutMapping("/book/{bookId}/update")
	    public ResponseEntity<?> put(@RequestBody Book book, @PathVariable(value = "bookId")long bookId){
	        return new ResponseEntity<>(service.editBook(book, bookId), HttpStatus.OK);
	    }
	  
	  @DeleteMapping("/delete/{bookId}")
	  public ResponseEntity<?> delete(@PathVariable(value="bookId")long bookId){
	        service.deleteBook(bookId);
	        return new ResponseEntity<>(new ApiResponse("book details has been removed successfully", true), HttpStatus.OK);
	    }
	

	
	

}
