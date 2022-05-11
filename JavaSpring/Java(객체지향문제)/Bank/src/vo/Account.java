package vo;

import java.io.Serializable;

public class Account implements Serializable{

	private String AccountNum;// ���¹�ȣ
	private int balance;// �ܰ�

	public Account(String accountNum, int balance) {
		super();
		AccountNum = accountNum;
		this.balance = balance;
	}

	public Account() {
		super();
	}

	public String getAccountNum() {
		return AccountNum;
	}

	public void setAccountNum(String accountNum) {
		AccountNum = accountNum;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "���¹�ȣ=" + AccountNum + ", �ܰ�=" + balance;
	}

}
