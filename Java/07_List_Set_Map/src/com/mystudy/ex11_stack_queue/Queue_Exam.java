package com.mystudy.ex11_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Exam {

	public static void main(String[] args) {
		// ť(Queue) : ���Լ���(FIFO)
		System.out.println("---- ť(Queue) : ���Լ���(FIFO) ---");
		Queue<String> que = new LinkedList<>();
		que.offer("1.ù°"); //�Է�
		que.add("2.��°"); //�Է�
		que.offer("3.��°");
		System.out.println("que : " + que);
		System.out.println("que.size() : " + que.size());
		
		System.out.println("\n--- peek() : Ȯ�θ� ---");
		System.out.println("que.peek() : " + que.peek());
		System.out.println("que.peek() : " + que.peek());
		System.out.println("ť���嵥���� : " + que);

		System.out.println("\n--- poll() : �����Ͳ����� ---");
		System.out.println("que.poll() : " + que.poll());
		System.out.println("que.poll() : " + que.poll());
		System.out.println("que.poll() : " + que.poll());
		System.out.println("que.poll() : " + que.poll()); //null : ������ ���� ��
		System.out.println("que.poll() : " + que.poll()); //null : ������ ���� ��
		System.out.println("ť���嵥���� : " + que);
		
		System.out.println("que.isEmpty() : " + que.isEmpty());
		System.out.println("que.size() : " + que.size());
		System.out.println("que.peek() : " + que.peek());
		
		System.out.println("---- Queue ��ü ������ ���� ---");
		que.offer("21.ù°"); //�Է�
		que.add("22.��°"); //�Է�
		que.offer("23.��°");
		System.out.println("que.isEmpty() : " + que.isEmpty());
		
		while (!que.isEmpty()) { //��� ���� ������(�����Ͱ� ������)
			System.out.println("que.poll() : " + que.poll());
		}
		System.out.println("que.isEmpty() : " + que.isEmpty());
		
		System.out.println("---------");
		que.offer("31.ù°"); //�Է�
		que.add("32.��°"); //�Է�
		que.offer("33.��°");
		System.out.println("que.size() : " + que.size());
		
		while (que.size() > 0) { //�����Ͱ� ������
			System.out.println("que.poll() : " + que.poll());
		}
		System.out.println("que.poll() : " + que.poll());
		System.out.println("que.size() : " + que.size());
		
		System.out.println("----- remove() ----");
		que.offer("41.ù°"); //�Է�
		que.add("42.��°"); //�Է�
		que.offer("43.��°");
		System.out.println("que.size() : " + que.size());
		
		while (que.size() > 0) { //�����Ͱ� ������
			System.out.println("que.remove() : " + que.remove());
		}
		//remove() : �����Ͱ� ������ NoSuchElementException ���ܹ߻�
		System.out.println("que.remove() : " + que.remove());
		System.out.println("que.size() : " + que.size());
	}

}










