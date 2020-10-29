package vo;

import java.io.Serializable;

public class TakeOut extends Food implements Serializable {

	private String address;

	public TakeOut(String orderNo, String name, int price, String address) {
		super(orderNo, name, price);
		this.address = address;
	}

	public TakeOut() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return super.toString() + ", 주소=" + address;
	}

}
