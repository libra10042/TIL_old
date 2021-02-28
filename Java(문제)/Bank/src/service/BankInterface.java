package service;

import vo.Account;
import vo.Client;

public interface BankInterface {

	public boolean insertClient(Client c);//고객등록
	public boolean registerAccount(String ssn,Account acc);//계좌등록	
	public boolean deposit(String accNum, int money);//해당계좌에입금
	public boolean withdrawal(String accNum, int money);//해당계좌에서출금
    public boolean transfer(String from,String to,int money);//2개의 계좌 사이 송금
    public void printAllClient();//고객정보 모두 출력
    public void printAllAccount(String ssn);//해당고객 계좌 모두 출력
    public void saveFile();//파일에 저장
    public void loadFile();//파일에서 로드

}
