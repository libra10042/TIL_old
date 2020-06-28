package com.myproject.vo;

public class SalesList 
{
	private String code; //�Ǹ��ڵ�
	private String pname; //�Ǹ��̸�
	private int quantity; //�Ǹŷ�
	private int saleAmount; //�Ǹż���
	
	public SalesList() {
		// TODO Auto-generated constructor stub
	}

	public SalesList(String code, String pname, int quantity, int saleAmount) {
		super();
		this.code = code;
		this.pname = pname;
		this.quantity = quantity;
		this.saleAmount = saleAmount;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}

	@Override
	public String toString() {
		return "SalesListVO [code=" + code + ", pname=" + pname + ", quantity=" + quantity + ", saleAmount="
				+ saleAmount + "]";
	}
	
	

}
