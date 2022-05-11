package service;

import vo.Account;
import vo.Client;

public interface BankInterface {

	public boolean insertClient(Client c);//�����
	public boolean registerAccount(String ssn,Account acc);//���µ��	
	public boolean deposit(String accNum, int money);//�ش���¿��Ա�
	public boolean withdrawal(String accNum, int money);//�ش���¿������
    public boolean transfer(String from,String to,int money);//2���� ���� ���� �۱�
    public void printAllClient();//������ ��� ���
    public void printAllAccount(String ssn);//�ش�� ���� ��� ���
    public void saveFile();//���Ͽ� ����
    public void loadFile();//���Ͽ��� �ε�

}
