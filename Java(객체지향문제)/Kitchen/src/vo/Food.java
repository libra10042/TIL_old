package vo;

import java.io.Serializable;

public class Food implements Serializable {

	private String orderNo;
	private String name;
	private int price;

	public Food(String orderNo, String name, int price) {
		super();
		this.orderNo = orderNo;
		this.name = name;
		this.price = price;
	}

	public Food() {

	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "음식명=" + name + ", 가격=" + price + ", 주문번호=" + orderNo;
	}

}
