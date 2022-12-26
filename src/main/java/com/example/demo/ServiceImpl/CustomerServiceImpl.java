package com.example.demo.ServiceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Book;
import com.example.demo.Entities.BookHistory;
import com.example.demo.Entities.Customer;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.BookHistoryRepository;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private BookRepository bRepo;
	
	@Autowired
	private BookHistoryRepository bHrepo;
	

	@Override
	public Customer addcustomer(Customer customer) {
		Customer newCustomer=cRepo.save(customer);
		return newCustomer;
	} 

	
	@Override
	public List<Book> searchForAbook(String name) {
		List<Book> books = cRepo.searchForAbook(name);
				if(books.isEmpty()) {
					throw new ResourceNotFoundException("Books not found");
				}
		return books;
	}

	

	@Override
	public BookHistory reserveBook(long bookId, long CustomerId, LocalDate bookReservationDate, LocalDate bookEndDate) {
		// TODO Auto-generated method stub
		Customer customer = cRepo.findById(CustomerId).get();
		BookHistory bHistory=new BookHistory();
		bHistory.setBookId(bookId);
	    bHistory.setCustomerId(CustomerId);
	    bHistory.setBookReservationDate(bookReservationDate);
	    bHistory.setBookEndDate(bookEndDate);
	    bHrepo.save(bHistory);
		customer.getBookHistory().add(bHistory);
		cRepo.save(customer);
		return bHistory;
		
	}


	@Override
	public Book getAllBooks(long bookId) {
		Book book = bRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("book not found with book id:" + bookId));
		return book;
	}


	
	
}
