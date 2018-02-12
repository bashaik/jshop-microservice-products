
package com.jshop.service;

import java.util.List;

public class ProductsResponse {
	
	private List<Product> products;

	public ProductsResponse() {

	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> productsParm) {
		products = productsParm;
	}

}