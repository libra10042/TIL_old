package com.myproject.vo;

public class Product {
	private String id;  //판매자 아이디 
	private String product; //상품이름
	private String price; //상품 가격
	private String cnt; //수량 
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String product, String price, String cnt) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.cnt = cnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product=" + product + ", price=" + price + ", cnt=" + cnt + "]";
	}
	
	
	
}
