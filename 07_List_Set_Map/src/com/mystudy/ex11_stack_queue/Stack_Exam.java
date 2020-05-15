package com.mystudy.ex11_stack_queue;

import java.util.Stack;

public class Stack_Exam {

	public static void main(String[] args) {
		System.out.println("==== 스택(Stack : LiFO - 후입선출) ===");
		Stack<String> st = new Stack<>();
		st.push("1.첫째"); //입력
		st.push("2.둘째");
		st.add("3.셋째"); //add() 사용해도 push()와 동일
		System.out.println("st : " + st);
		
		System.out.println("size() : " + st.size());
		System.out.println("peek() : " + st.peek()); //마지막 입력 데이터 조회
		System.out.println("peek() : " + st.peek());
		System.out.println("peek() : " + st.peek());
		System.out.println("size() : " + st.size());
		
		System.out.println("--- pop() : 데이터 꺼내기 ----");
		//데이터 없으면 EmptyStackException 예외발생
		System.out.println("pop() : " + st.pop());
		System.out.println("pop() : " + st.pop());
		System.out.println("pop() : " + st.pop());
		//System.out.println("pop() : " + st.pop()); //데이터 없으면 EmptyStackException 예외발생
		System.out.println("st : " + st);
		
		System.out.println("---- 스택(Stack) 전체 데이터 사용 ---");
		System.out.println("st.empty() : " + st.empty());
		System.out.println("st.isEmpty() : " + st.isEmpty());
		System.out.println(">> 데이터 입력");
		st.push("21.첫째"); //입력
		st.push("22.둘째");
		st.push("23.셋째"); 
		System.out.println("st.empty() : " + st.empty());
		while (!st.empty()) { //스택이 비어 있지 않으면
			System.out.println("st.pop() : " + st.pop());
		}
		System.out.println("st.empty() : " + st.empty());
		
		System.out.println("-----");
		System.out.println(">> 데이터 입력");
		st.push("31.첫째"); //입력
		st.push("32.둘째");
		st.push("33.셋째"); 
		System.out.println("st.size() : " + st.size());
		while (st.size() > 0) {
			System.out.println("st.pop() : " + st.pop());
		}
		System.out.println("st.size() : " + st.size());
		
	}

}


















