package com.mystudy.ex03_vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorExam {

	public static void main(String[] args) {
		//Vector Ŭ���� : �������̽� List �迭
		//Vector<String> v = new Vector<String>(5);
		Vector<String> v = new Vector<>(5); //����뷮 5
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		v.add("1"); //index : 0
		v.add("2"); //index : 1
		v.add("3"); //index : 2
		System.out.println("v : " + v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());

		System.out.println("--- v.remove(2) ���� �� ---");
		v.remove(2); //2�� �ε����� ����
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		System.out.println("--- v.trimToSize() ���� �� ---");
		v.trimToSize();
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		v.addElement("4"); //�߰����
		System.out.println("v :" + v);
		
		v.add("AA"); //�߰� �Է�(�ǵڿ� insert)
		System.out.println("v :" + v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		v.remove("2");
		System.out.println("v :" + v);
		
		v.add(2, "BB"); //�Է�, Ư����ġ�� �Է�(insert)
		System.out.println("v :" + v);
		
		v.set(2, "CCC"); //����(update)
		System.out.println("v :" + v);
		
		//set() ���� �����Ͱ� ���� �� ���ٽ� ���� �߻�
		//v.set(4, "DDDD"); //ArrayIndexOutOfBoundsException
		
		//remove() ���� �����Ͱ� ���� �� ���ٽ� ���� �߻�
		//v.remove(4); //ArrayIndexOutOfBoundsException
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		System.out.println("===== ��ü����(clone()) =====");
		Vector<String> v2 = (Vector<String>) v.clone();
		System.out.println("v : " + v);
		System.out.println("v2 : " + v2);
		
		System.out.println("--- v2.clear() ���� �� ----");
		v2.clear();
		System.out.println("v : " + v);
		System.out.println("v2 : " + v2);
		
		System.out.println("==== Enumeration ��ü ��� ��ȸ ====");
		Enumeration<String> enu = v.elements();
		while (enu.hasMoreElements()) {
			String str = enu.nextElement();
			System.out.println("enu.nextElement() : "+ str);
		}
		System.out.println("v : " + v);
		
		System.out.println("==== Iterator Ȱ�� ��ȸ =====");
		Iterator<String> ite = v.iterator();
		while (ite.hasNext()) {
			String str = ite.next();
			System.out.println("ite.next() : " + str);
		}
		System.out.println("ite.hasNext() : " + ite.hasNext());
		//Iterator ��ü�� �� �� ����ϸ� ���� �ȵ�
		//��� ����ϴ� ��� : NoSuchElementException �߻�
		System.out.println("ite.next() : " + ite.next());
	}

}



















