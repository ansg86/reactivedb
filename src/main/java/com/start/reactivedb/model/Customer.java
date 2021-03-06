package com.start.reactivedb.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Value
@Builder
public class Customer {

	@Id
	Long id;
	
	String firstName;
	
	String lastName;
}
