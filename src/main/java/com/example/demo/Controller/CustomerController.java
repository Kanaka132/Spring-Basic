package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Book;
import com.example.demo.Entities.BookHistory;
import com.example.demo.Entities.Customer;
import com.example.demo.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@PostMapping("/new/customer")
	 public ResponseEntity<?> post(@RequestBody Customer customer){
	    return new ResponseEntity<>(cService.addcustomer(customer),HttpStatus.CREATED);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchForAbook(@RequestParam("name") String name) {
		return ResponseEntity.ok(cService.searchForAbook(name));
	}

	@PostMapping("/reservebook")
	public ResponseEntity<?> reserveBook(@RequestBody BookHistory bookHistory) {
		return new ResponseEntity<>(cService.reserveBook(bookHistory.getBookId(), bookHistory.getCustomerId(), bookHistory.getBookReservationDate(), bookHistory.getBookEndDate()),HttpStatus.CREATED);

	@GetMapping("/book/{bookId}") ResponseEntity<List<Book>> getAllBooks(@RequestParam("bookId")){
		return new ResponseEntity<>(cService.getAllBooks(bookId),HttpStatus.OK);
		
	}
	}

}
