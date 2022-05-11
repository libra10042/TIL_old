package com.myproject.vo;


public class Sales 
{
	private int num; //�Ǹ� ��ȣ
	private String inputdate; //��ϳ�¥
	private String code; //�Ǹ��ڵ�
	private int quantity; //�Ǹŷ�
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(int num, String inputdate, String code, int quantity) {
		super();
		this.num = num;
		this.inputdate = inputdate;
		this.code = code;
		this.quantity = quantity;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "SalesVO [num=" + num + ", inputdate=" + inputdate + ", code=" + code + ", quantity=" + quantity + "]";
	}
	
	
	
}
