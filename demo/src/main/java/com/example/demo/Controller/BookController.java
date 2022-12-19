package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entities.Book;
import com.example.demo.Exception.ApiResponse;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Service.BookService;






@RestController
@RequestMapping("/book")
public class BookController<Public> {

//	private static final long book = 0;
	@Autowired
	private  BookService service;
//	public BookController(BookRepository repo) {
//		this.repo=repo;
//		// TODO Auto-generated constructor stub
//	}
	
	  @PostMapping("/new/book")	   
	    public ResponseEntity<?> post(@RequestBody Book book){
	        return new ResponseEntity<>(service.addBook(book), HttpStatus.CREATED);
	    }
	  
	  @DeleteMapping("/delete")
	  public ResponseEntity<?> delete(@PathVariable(value = "bookId")long bookId){
	        service.deleteBook(bookId);
	        return new ResponseEntity<>(new ApiResponse("book details has been removed successfully", true), HttpStatus.OK);
	    }
//	@PostMapping("/books")
//	Public Book createBook (@RequestBody Book newBook) {
//		return repo.save(newBook);
//	}

//	@GetMapping("/books")
//	public List<Book> getAllBooks(){
//		return service.findAll();
//	}
	
//	@GetMapping("/books/{id}")
//    public ResponseEntity < Book > getBookById(@PathVariable(value = "id") Long BookId)
//    throws ResourceNotFoundException {
//        Book book = service.findById(BookId)
//            .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + BookId));
//        return ResponseEntity.ok().body(book);
//    }
	
	
	
//	@DeleteMapping("/book/{bookId}/remove")
//   public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//	try {
//		repo.deleteById(id);
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	} catch (Exception e) {
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
