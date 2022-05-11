package com.myproject.dao;

import java.util.ArrayList;

import com.myproject.vo.Admin;
import com.myproject.vo.Product;
import com.myproject.vo.SalesList;
import com.myproject.vo.Sales;

public interface AbstractInventoryDAO {

	
	public boolean login(Admin vo); //������ �α��� 
	public boolean insertMember(Admin vo);  //������ ȸ������
	
	public int insertProduct(Product vo); //��ǰ ��� 
	public ArrayList<Product> listProduct(); //��ǰ ��ü ���� 
	public int insert(Sales vo); //�Ǹ� ���� ��� 
	public ArrayList<Sales> list(); //�Ǹ� ���� ��ü����.
	public int update(Sales vo); //�Ǹ� ���� ����
	public int delete(int num); //�Ǹ� ���� ���� 
	public ArrayList<SalesList> sales(); //��ǰ�� �Ǹ� ���� ���� ����. 
	
	



	
}


