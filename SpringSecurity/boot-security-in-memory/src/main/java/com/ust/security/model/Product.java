package com.ust.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	Integer productId;
	String name;
	String category;
	String brand;
	double price;
}
