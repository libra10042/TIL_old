package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import vo.Customer;
import vo.DineIn;
import vo.Food;
import vo.TakeOut;

public class KitchenService implements ServiceInterface {

	private ArrayList<Customer> customerlist = new ArrayList<Customer>();
	private ArrayList<Food> orderlist = new ArrayList<>();
	private ArrayList<Food> completelist = new ArrayList<>();

	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	private final String FOODFILENAME = "kitchen.dat";
	private final String CUSTOMERFILENAME = "hall.dat";

	public KitchenService() {
		loadCustomerFile();
		loadFoodFile();
	}

	@Override
	public boolean insertCustomer(Customer c) {
		boolean flag = true;
		if (searchCustomer(c.getPhoneNum()) == null) {
			customerlist.add(c);
			saveCustomerFile();
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean orderFood(String phoneNum, Food f) {
		boolean flag = false;

		if (searchCustomer(phoneNum) == null) {
			return flag;
		} else if (searchFood(f.getOrderNo()) == null) {
			orderlist.add(f);
			searchCustomer(phoneNum).getOrderList().add(f);
			saveFoodFile();
			flag = true;
		}

		return flag;
	}

	@Override
	public Customer searchCustomer(String phoneNum) {
		Customer result = null;
		for (Customer customer : customerlist) {
			if (customer.getPhoneNum().equals(phoneNum)) {
				result = customer;
			}
		}
		return result;
	}

	@Override
	public Food searchFood(String orderNum) {
		Food result = null;
		for (Food food : orderlist) {
			if (food.getOrderNo().equals(orderNum)) {
				result = food;

			}
		}

		return result;
	}

	@Override
	public void completeFood(Food f) {
		orderlist.remove(f);
		completelist.add(f);
		saveFoodFile();

	}
	
	@Override
	public String serveFood(String orderNo) {
		String result = "";
		boolean flag = false;
		
		ArrayList<Food> cfList=new ArrayList<>();
		cfList.addAll(completelist);
		
		
		for(int i=0;i<cfList.size();i++) {
			if (cfList.get(i).getOrderNo().equals(orderNo)) {
				result += cfList.get(i) + "\n";
				completelist.remove(i);
				saveFoodFile();
				flag = true;
			}
		}

		for (Customer c : customerlist) {
			for (int i = 0; i < c.getOrderList().size(); i++) {
				if (c.getOrderList().get(i).getOrderNo().equals(orderNo)) {

					if (c.getOrderList().get(i) instanceof DineIn) {
						result += "서빙 테이블 : " + ((DineIn) c.getOrderList().get(i)).getTableNo();
					} else if (c.getOrderList().get(i) instanceof TakeOut) {
						result += "배달 주소 : " + ((TakeOut) c.getOrderList().get(i)).getAddress();
					}

					flag = true;
				}
			}
		}

		if(flag) {
			saveFoodFile();
		}
		return result;
	}
	@Override
	public String mostBoughtCustomer() {
		String result = "";
		Customer temp = null;

		for (int i = 0; i < customerlist.size(); i++) {
			for (int j = i + 1; j < customerlist.size(); j++) {
				if (customerlist.get(i).getOrderList().size() < customerlist.get(j).getOrderList().size()) {
					temp = customerlist.get(i);
					customerlist.set(i, customerlist.get(j));
					customerlist.set(j, temp);
				}
			}
		}

		for (Customer c : customerlist) {
			result += c + "\n";
		}

		return result;
	}

	@Override
	public String calculateAll() {
		String result = "총 판매액";
		int total = 0;
		for (int i = 0; i < customerlist.size(); i++) {
			for (int j = 0; j < customerlist.get(i).getOrderList().size(); j++) {
				total += customerlist.get(i).getOrderList().get(j).getPrice();
			}
		}
		result += total + "원";

		return result;
	}

	@Override
	public String getComplete() {
		String result = "";
		loadFoodFile();
		for (Food f : completelist) {
			result += f + "\n";
		}
		return result;
	}

	@Override
	public String getOrderList() {
		String result = "";
		loadFoodFile();
		for (Food f : orderlist) {
			result += f + "\n";

		}
		return result;
	}

	@Override
	public String getCustomerList() {
		String result = "";
		loadCustomerFile();
		for (Customer c : customerlist) {
			result += c + "\n";
		}

		return result;
	}

	@Override
	public void saveFoodFile() {
		try {
			// orderlist와 completelist 를 저장할 Arraylist를 새로 만들어준다.
			ArrayList<ArrayList<Food>> flist = new ArrayList<>();
			flist.add(orderlist);
			flist.add(completelist);
			oos = new ObjectOutputStream(new FileOutputStream(new File(FOODFILENAME)));
			oos.writeObject(flist);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
	public void loadFoodFile() {
		if (new File(FOODFILENAME).exists()) {
			try {
				ArrayList<ArrayList<Food>> flist = new ArrayList<>();
				ois = new ObjectInputStream(new FileInputStream(new File(FOODFILENAME)));
				flist = (ArrayList<ArrayList<Food>>) ois.readObject();
				orderlist = (ArrayList<Food>) flist.get(0);
				completelist = (ArrayList<Food>) flist.get(1);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Override
	public void saveCustomerFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(CUSTOMERFILENAME)));
			oos.writeObject(customerlist);

		} catch (IOException e) {
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
	public void loadCustomerFile() {
		if (new File(CUSTOMERFILENAME).exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(new File(CUSTOMERFILENAME)));
				customerlist = (ArrayList<Customer>) ois.readObject();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

}
