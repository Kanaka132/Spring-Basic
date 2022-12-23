package com.example.demo.Entities;

import java.util.Date;

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
public class BookHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long bookHistoryId;
	private long bookId;
	private long customerId;
	
	private Date bookReservationDate;
	private Date bookEndDate;
	private String bookReturnStatus;
	
	
}