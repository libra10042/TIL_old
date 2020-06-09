package com.myproject.dao;

import java.util.ArrayList;


import com.myproject.vo.Member;
import com.myproject.vo.Product;
import com.myproject.vo.SalesList;
import com.myproject.vo.Sales;


public interface AbstractInventoryDAO {

	
	public boolean loginMember(Member vo); //ȸ�� �α���. 0
	public boolean insertMember(Member vo);// ȸ�����. 0
	
	
	/*------------- ������ ��� ----------------*/
	public ArrayList<Member> printAllMember(); // ��� ��ü ����ϱ�
	
	public Member SalesInfo(); //�Ǹ��ں� ���� ���� Ȯ��. 
	
	/*------------- �Ǹ��� ��� ----------------*/

	
	public int insertProduct(Product vo); //��ǰ ������ db�� �����Ѵ�.
	public ArrayList<Product> listProduct(); //DB�� ����� ��� ��ǰ������ �ڵ� ������ �о�´�.
	public int insert(Sales vo); // �Ǹ������� db�� �����Ѵ�.
	public ArrayList<Sales> list(); //DB�� ����� ��� �Ǹ� ������ ��¥������ �о�´�.
	public int update(Sales vo); // ��ȣ�� �Ǹż����� ���޹޾� �ش� ��ȣ�� �����͸� �����Ѵ�.
	public int delete(int num); //��ȣ�� ���޹޾� �ش� �Ǹ� ������ �����Ѵ�.
	public ArrayList<SalesList> sales(); //��ǰ���� �Ǹż����� �Ǹűݾ��� ���Ѵ�. (�Ǹ������� ���)
	
	
	
	

	



	
}


