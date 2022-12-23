package com.example.demo.Controller;

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

	@PostMapping("/reservebook/{bookId}/{customerId}")
	public ResponseEntity<?> reserveBook(@PathVariable(value = "bookId") long bookId,
			@PathVariable(value = "customerId") long customerId, @RequestBody Date bookReservationDate,
			@RequestBody Date bookEndDate) {
		return new ResponseEntity<>(cService.reserveBook(bookId, customerId, bookReservationDate, bookEndDate),
				HttpStatus.CREATED);
	}

}
