package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable{

	private String name;// ����
	private String ssn;// �ֹε�Ϲ�ȣ
	private String address;// �ּ�
	private String phoneNum;// �ڵ��� �ּ�
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
		return "����=" + name + ", �ֹε�Ϲ�ȣ=" + ssn + ", �ּ�=" + address + ", �ڵ�����ȣ=" + phoneNum;
	}

}
