package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.Engineering;

import vo.Account;
import vo.Client;
import vo.DepositAccount;
import vo.MinusAccount;

public class BankService implements BankInterface {
	private ArrayList<Client> clientList = new ArrayList<>();

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private final String FILENAME = "bank.dat";

	
	public BankService() {
		loadFile();
	}

	@Override
	public boolean insertClient(Client c) {
		boolean flag = true;
		for (Client client : clientList) {
			if (client.getSsn().equals(c.getSsn())) {
				flag = false;
			}
		}

		if (flag) {
			clientList.add(c);
			saveFile();
		}
		return flag;
	}

	@Override
	public boolean registerAccount(String ssn, Account acc) {
		boolean flag = true;
		boolean ssnExists = false;
		for (Client client : clientList) {
			for (int i = 0; i < client.getAccList().size(); i++) {
				if (client.getAccList().get(i).getAccountNum().equals(acc.getAccountNum())) {
					flag = false;
				}
			}
		}
		if (flag) {
			for (Client client : clientList) {
				if (client.getSsn().equals(ssn)) {
					client.getAccList().add(acc);
					ssnExists = true;
					saveFile();
				}
			}
		}

		return flag && ssnExists;
	}

	@Override
	public boolean deposit(String accNum, int money) {
		boolean flag = false; 
		if(money >=0) {
			for(Client client : clientList) {
				for(int i=0; i<client.getAccList().size(); i++) {
					if(client.getAccList().get(i).equals(accNum)) {
						client.getAccList().get(i).setBalance(client.getAccList().get(i).getBalance()+ money);
						flag = true; 
						saveFile();
					}
				}
			}
		}
		return flag;
	}

	@Override
	public boolean withdrawal(String accNum, int money) {
		boolean flag = false; 
		
		if(money >=0) {
			for(Client client : clientList) {
				for(int i=0; i<client.getAccList().size(); i++) {
					if(client.getAccList().get(i).equals(accNum)) {
						
						if(client.getAccList().get(i) instanceof DepositAccount) {
							if(client.getAccList().get(i).getBalance() < money) {
								return false; 
							}else {
								client.getAccList().get(i).setBalance(client.getAccList().get(i).getBalance() - money);
								saveFile();
								return true; 
							}
						}else if(client.getAccList().get(i) instanceof MinusAccount) {
							client.getAccList().get(i).setBalance(client.getAccList().get(i).getBalance() - money);
							saveFile();
							return true; 
						}
						
						
					}
				}
			}
		}
		return flag;
	}

	@Override
	public boolean transfer(String from, String to, int money) {
		boolean fromflag = true;
		boolean toflag = true; 
		
		fromflag = deposit(to, money);
		toflag = withdrawal(from, money);
		
		if(!fromflag) {
			withdrawal(to, money);
		}
		if(!toflag) {
			deposit(from, money);
		}
		
		if(fromflag) {
			saveFile();
		}
		
		return fromflag && toflag;
	}

	@Override
	public void printAllClient() {
		StringBuilder result = new StringBuilder();
		for(Client client : clientList) {
			result.append(client).append("\n");
		}
		System.out.println(result);
	}

	@Override
	public void printAllAccount(String ssn) {
		StringBuilder result = new StringBuilder();
		for(Client client : clientList) {
			if(ssn.equals(client.getSsn())) {
				for(Account account : client.getAccList()) {
					result.append(account).append("\n");
				}
			}
				
		}
		System.out.println(result);
	}

	@Override
	public void saveFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
			oos.writeObject(clientList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void loadFile() {
		// TODO Auto-generated method stub

		if (new File(FILENAME).exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(new File(FILENAME)));
				clientList = (ArrayList<Client>) ois.readObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (ois != null)
					try {
						ois.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}

	}

}
