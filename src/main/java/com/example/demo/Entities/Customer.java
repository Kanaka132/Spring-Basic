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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String customerName;
	private long customerPhone;
	private String customerEmail;
}
