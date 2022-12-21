package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;
	private String bookName;
	private String bookDesc;
	private long bookQuantity;
	
	
	
}
