package com.spring.domain;
public class ProductVO {
	private String name;  // 제품명
	private double price; // 가격

	public ProductVO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
			return "ProductVO[name=" + name + ", price= " + price + "]";
	}	
}
