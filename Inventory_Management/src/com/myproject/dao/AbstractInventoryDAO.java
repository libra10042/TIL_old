package com.myproject.dao;

import java.util.ArrayList;

import com.myproject.vo.Admin;
import com.myproject.vo.Member;
import com.myproject.vo.Product;

public interface AbstractInventoryDAO {

	public boolean insertMebmer(Member vo); //ȸ�� ����.
	public boolean printAllMember(); //�� ���� ��� ���. 
	
	/*-----------������ ���--------------- */
	/*
	 ������ ȸ������ ������ db�� �����Ѵ�. 
	 */
	public int insertAdmin(Admin vo);

	/*
	 ������ �α���
	 */
	public boolean loginAdmin(Admin admin);
	
	
	/*
	 ȸ�������� �ҷ��´�.
	 */
	public ArrayList<Member> searchAllMember();
	
	
	
	/*
	 ���Ե� ȸ�� ��ü ���� ���. 
	 */
	public ArrayList<Member> loginAdmin();
	
	/*
	  
	 
	 */
	
	
	
	/*--------------------------------------------------------------*/
	/* Ư�� ǰ�� ���� ��� Ȯ���ϴ� �޼ҵ� 
	 @param productId : ��� Ȯ���� ǰ�� ���� id
	 @return Product : ��� Ȯ�ε� ǰ�� ��ü
	 */
	public Product stockCheck(String productId);
	
	/*
	 �Ǹ��ϴ� ��ü ǰ�� ���� ��� Ȯ��
	 */
	public Product allstockCheck();
	
	
	
	/*
	 ���ο� Ǯǰ ���
	 @param product : �Ǹ��ڰ� �ȸ��� ���ο� ��ǰ�� ����Ѵ�.
	 @return        ��� ����(true: ��� �Ϸ�, false: ��ϺҰ�)
	 */
	public boolean stockCreate(Product product);
	
	
	
	/*
	 
	  
	 */
	
	
	
	
	/*--------------------------------------------------------------*/
	

	
}


