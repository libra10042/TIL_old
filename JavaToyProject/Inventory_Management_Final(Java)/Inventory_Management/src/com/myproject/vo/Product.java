package com.myproject.vo;

//��ǰ����
public class Product
{
	private String code; //��ǰ�ڵ�
	private String pname; //��ǰ�̸�
	private int price; //��ǰ����
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String code, String pname, int price) {
		super();
		this.code = code;
		this.pname = pname;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [code=" + code + ", pname=" + pname + ", price=" + price + "]";
	}
	

	
}
