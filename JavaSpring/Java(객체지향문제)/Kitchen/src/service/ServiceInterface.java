package service;

import vo.Customer;
import vo.Food;

public interface ServiceInterface {

	public boolean insertCustomer(Customer c); //고객객체를 등록한다

	public boolean orderFood(String phoneNum, Food f);// 해당 고객에 음식주문을 등록한다. 매장내 음식이든 배달이든 모두 리스트에 넣는다.

	public Customer searchCustomer(String phoneNum);//해당 핸드폰번호의 고객을 찾는다.

	public Food searchFood(String orderNum);//해당 주문번호의 음식을 찾는다.

	public void completeFood(Food f);//주문된 음식을 "완성된요리 리스트"에 넣는다.

	public String serveFood(String orderNum);//완성된 요리리스트의 음식을 배달 또는 서빙한다. 해당음식은  "완성된요리 리스트"에서 제외된다. 

	public String mostBoughtCustomer();//가장 배달량이 많은 고객순서로 출력된다.

	public String calculateAll();//모든 매출액을 출력한다.

	public String getComplete();//주방에서 만들어진 완성된 리스트의 음식을 모두 출력한다.

	public String getOrderList();//주방에서 만들 이제 막 주문된 음식들의 리스트 전체를 출력한다.

	public String getCustomerList();//고객의 모든 정보를 출력한다.

	public void saveFoodFile();//주방과 공유할 정보를 파일에 저장한다.

	public void loadFoodFile();//주방과 공유할 정보를 파일에서 로드한다.

	public void saveCustomerFile();//고객 정보를 파일에서 로드한다.

	public void loadCustomerFile();//고객 정보를 파일에서 로드한다.

}
