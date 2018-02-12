
package com.jshop.service;

import java.util.Objects;

public class Product {
	private int id;
	private String name;
	private String price;

	public Product() {

	}

	public Product(int idParm, String nameParm, String priceParm) {
		super();
		id = idParm;
		name = nameParm;
		price = priceParm;
	}

	public int getId() {
		return id;
	}

	public void setId(int idParm) {
		id = idParm;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameParm) {
		name = nameParm;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String priceParm) {
		price = priceParm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(Object objParm) {
		if (objParm == this) {
			return true;
		}
		if (!(objParm instanceof Product)) {
			return false;
		}

		Product product = (Product) objParm;
		return Objects.equals(name, product.name);
	}
	
}