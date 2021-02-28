package vo;

import java.io.Serializable;

public class DineIn extends Food implements Serializable {

	private String tableNo;

	public DineIn(String orderNo, String name, int price, String tableNo) {
		super(orderNo, name, price);
		this.tableNo = tableNo;
	}

	public DineIn() {
		super();
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}

	@Override
	public String toString() {
		return super.toString() + ", 테이블번호=" + tableNo;
	}

}
