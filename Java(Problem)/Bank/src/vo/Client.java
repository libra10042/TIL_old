package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable{

	private String name;// 고객명
	private String ssn;// 주민등록번호
	private String address;// 주소
	private String phoneNum;// 핸드폰 주소
	private List<Account> accList = new ArrayList<>();

	public Client(String name, String ssn, String address, String phoneNum) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public Client() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
	
	public List<Account> getAccList() {
		return accList;
	}

	public void setAccList(List<Account> accList) {
		this.accList = accList;
	}

	@Override
	public String toString() {
		return "고객명=" + name + ", 주민등록번호=" + ssn + ", 주소=" + address + ", 핸드폰번호=" + phoneNum;
	}

}
