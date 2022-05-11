package com.mystudy.ex03_vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorExam {

	public static void main(String[] args) {
		//Vector 클래스 : 인터페이스 List 계열
		//Vector<String> v = new Vector<String>(5);
		Vector<String> v = new Vector<>(5); //저장용량 5
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		v.add("1"); //index : 0
		v.add("2"); //index : 1
		v.add("3"); //index : 2
		System.out.println("v : " + v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());

		System.out.println("--- v.remove(2) 실행 후 ---");
		v.remove(2); //2번 인덱스값 삭제
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		System.out.println("--- v.trimToSize() 실행 후 ---");
		v.trimToSize();
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		v.addElement("4"); //추가기능
		System.out.println("v :" + v);
		
		v.add("AA"); //추가 입력(맨뒤에 insert)
		System.out.println("v :" + v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		v.remove("2");
		System.out.println("v :" + v);
		
		v.add(2, "BB"); //입력, 특정위치에 입력(insert)
		System.out.println("v :" + v);
		
		v.set(2, "CCC"); //수정(update)
		System.out.println("v :" + v);
		
		//set() 사용시 데이터가 없는 곳 접근시 예외 발생
		//v.set(4, "DDDD"); //ArrayIndexOutOfBoundsException
		
		//remove() 사용시 데이터가 없는 곳 접근시 예외 발생
		//v.remove(4); //ArrayIndexOutOfBoundsException
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		System.out.println("===== 객체복사(clone()) =====");
		Vector<String> v2 = (Vector<String>) v.clone();
		System.out.println("v : " + v);
		System.out.println("v2 : " + v2);
		
		System.out.println("--- v2.clear() 실행 후 ----");
		v2.clear();
		System.out.println("v : " + v);
		System.out.println("v2 : " + v2);
		
		System.out.println("==== Enumeration 객체 사용 조회 ====");
		Enumeration<String> enu = v.elements();
		while (enu.hasMoreElements()) {
			String str = enu.nextElement();
			System.out.println("enu.nextElement() : "+ str);
		}
		System.out.println("v : " + v);
		
		System.out.println("==== Iterator 활용 조회 =====");
		Iterator<String> ite = v.iterator();
		while (ite.hasNext()) {
			String str = ite.next();
			System.out.println("ite.next() : " + str);
		}
		System.out.println("ite.hasNext() : " + ite.hasNext());
		//Iterator 객체는 한 번 사용하면 재사용 안됨
		//계속 사용하는 경우 : NoSuchElementException 발생
		System.out.println("ite.next() : " + ite.next());
	}

}



















