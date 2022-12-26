package com.example.demo.Service;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.demo.Entities.Book;
import com.example.demo.Entities.BookHistory;
import com.example.demo.Entities.Customer;

public interface CustomerService {

	Customer addcustomer(Customer customer);
	
	List<Book> searchForAbook(String name);
	
	Book getAllBooks(long bookId);
	
	BookHistory reserveBook(long bookId,long CustomerId,LocalDate bookReservationDate,LocalDate bookEndDate);
}
