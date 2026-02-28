package com.cg.ShopCart.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ShopCart.model.Product;

@Service
public class ProductServie {
	private static List<Product> products=Arrays.asList
			(new Product(1,"mobile",120000),
			 new Product(2,"laptop",76000),
			 new Product(3,"washing machine",45000)
					);

	public static List<Product> getProducts() {
		return products;
	}
	public Product getProductById(int id) {
		return products.stream().filter(n->n.getProductId()==id).findFirst().orElse(null);
	}
	
	
	
			

}
