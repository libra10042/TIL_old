package com.mystudy.ex11_stack_queue;

import java.util.Stack;

public class Stack_Exam {

	public static void main(String[] args) {
		System.out.println("==== ����(Stack : LiFO - ���Լ���) ===");
		Stack<String> st = new Stack<>();
		st.push("1.ù°"); //�Է�
		st.push("2.��°");
		st.add("3.��°"); //add() ����ص� push()�� ����
		System.out.println("st : " + st);
		
		System.out.println("size() : " + st.size());
		System.out.println("peek() : " + st.peek()); //������ �Է� ������ ��ȸ
		System.out.println("peek() : " + st.peek());
		System.out.println("peek() : " + st.peek());
		System.out.println("size() : " + st.size());
		
		System.out.println("--- pop() : ������ ������ ----");
		//������ ������ EmptyStackException ���ܹ߻�
		System.out.println("pop() : " + st.pop());
		System.out.println("pop() : " + st.pop());
		System.out.println("pop() : " + st.pop());
		//System.out.println("pop() : " + st.pop()); //������ ������ EmptyStackException ���ܹ߻�
		System.out.println("st : " + st);
		
		System.out.println("---- ����(Stack) ��ü ������ ��� ---");
		System.out.println("st.empty() : " + st.empty());
		System.out.println("st.isEmpty() : " + st.isEmpty());
		System.out.println(">> ������ �Է�");
		st.push("21.ù°"); //�Է�
		st.push("22.��°");
		st.push("23.��°"); 
		System.out.println("st.empty() : " + st.empty());
		while (!st.empty()) { //������ ��� ���� ������
			System.out.println("st.pop() : " + st.pop());
		}
		System.out.println("st.empty() : " + st.empty());
		
		System.out.println("-----");
		System.out.println(">> ������ �Է�");
		st.push("31.ù°"); //�Է�
		st.push("32.��°");
		st.push("33.��°"); 
		System.out.println("st.size() : " + st.size());
		while (st.size() > 0) {
			System.out.println("st.pop() : " + st.pop());
		}
		System.out.println("st.size() : " + st.size());
		
	}

}


















