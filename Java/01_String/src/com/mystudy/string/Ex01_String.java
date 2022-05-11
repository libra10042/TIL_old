package com.mystudy.string;

public class Ex01_String {

	public static void main(String[] args) {
		/* String Ŭ���� : ���ڿ� ����, ó���ϱ� ���� Ŭ����
			String ���� �Һ�(immutable) : ��(����Ÿ)�� ������ �� ����
		������� 2����
		String str = "ȫ�浿"; //�⺻ ����Ÿ Ÿ�� ��������� ��� ����
		String str = new String("ȫ�浿"); //��ü(�ν��Ͻ�) ���� ���
		-------------------------- */
		String str1 = "Java";
		
		String strObj1 = new String("Java");
		System.out.println("str1 : " + str1);
		System.out.println("strObj1 : " + strObj1);
		
		String str11 = "Java";
		System.out.println("--------------");
		// == : ���ϵ���Ÿ(���ϰ�ü)���� Ȯ��
		System.out.println("str1 == strObj1 : " + (str1 == strObj1));
		System.out.println("str1 == str11 : " + (str1 == str11));
		
		System.out.println("---- ���ڿ� �� ��(������ ���ڿ�) ---");
		System.out.println("str1.equals(strObj1) : " + str1.equals(strObj1));
		
		String strObj11 = new String("Java");
		System.out.println("strObj11 : " + strObj11);
		System.out.println("str1 == strObj11 : " + (str1 == strObj11));
		System.out.println("str1.equals(strObj11) : " + str1.equals(strObj11));
		System.out.println("-------");
		System.out.println("strObj1 == strObj11 : " + (strObj1 == strObj11));
		System.out.println("strObj1.equals(strObj11) : " + strObj1.equals(strObj11));
		
		System.out.println("--------");
		String str12 = "JAVA";
		System.out.println("str12 : " + str12);
		//                  "JAVA"   vs  "Java"
		System.out.println("str12.equals(strObj11) : " + str12.equals(strObj11));
		System.out.println("str12.equalsIgnoreCase(strObj11) : " 
				+ str12.equalsIgnoreCase(strObj11));
		
		//===============================
		System.out.println("----- concat() ------");
		String a = "Hello ";
		String b = "Java ";
		String c = "World!";
		System.out.println("a + b + c : " + (a + b + c));
		System.out.println("a.concat(b) : " + a.concat(b));
		
		//ü�̴�(chainning) ���
		String result = a.concat(b).concat(c).concat("!!!");
		System.out.println(result);
	}

}




























