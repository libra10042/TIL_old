package vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {

	private String name;// 이름
	private String phoneNum;// 전화번호
	private ArrayList<Food> orderList = new ArrayList<>();// 주문목록

	public Customer(String name, String phoneNum) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public Customer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public ArrayList<Food> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Food> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 전화번호=" + phoneNum + ", 주문내역=" + orderList;
	}

}
