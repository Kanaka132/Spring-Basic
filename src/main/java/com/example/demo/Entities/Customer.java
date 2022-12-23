package com.example.demo.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String customerName;
	private long customerPhone;
	private String customerEmail;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private List<Book> books;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private List<BookHistory> bookHistory;
}
