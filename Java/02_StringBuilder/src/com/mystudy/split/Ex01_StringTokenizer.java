package com.mystudy.split;

import java.util.StringTokenizer;

public class Ex01_StringTokenizer {

	public static void main(String[] args) {
		// String.split() vs StringTokenizer Ŭ����
		System.out.println("---- String.split() ---");
		String str = "���,��,������, ,����";
		System.out.println("str : " + str);

		String[] strSplit = str.split(",");
		System.out.println("strSplit.length : " + strSplit.length);
		
		for (int i = 0; i < strSplit.length; i++) {
			System.out.println(i + " : -" + strSplit[i] +"-");
		}
		
		System.out.println("---- ������ for�� ---");
		//������ for��(�ٸ���� : forEach��)
		//for (������Ÿ��  ������  : ���հ�ü) {}
		for (String str2 : strSplit) {
			System.out.println("-" + str2 + "-");
		}
		System.out.println("------------");
		
		int idx = 0;
		for (String str2 : strSplit) {
			System.out.println(idx + ": -" + str2 + "-");
			idx++;
		}
		System.out.println("================================");
		System.out.println("--- StringTokenizer Ŭ���� ��� ----");
		System.out.println("str : " + str);
		StringTokenizer strToken = new StringTokenizer(str, ",");
		System.out.println("strToken.countTokens() : " 
				+ strToken.countTokens());
		
		while (strToken.hasMoreTokens()) { //��ū�� �� �ֳ�?
			String token = strToken.nextToken(); //��ū�� ���
			System.out.println("-" + token + "-");
		}
		System.out.println("strToken.countTokens() : " 
				+ strToken.countTokens());
		
		System.out.println("==== ��ū�� ����ȸ (for��) ====");
		strToken = new StringTokenizer(str, ",");
		System.out.println("����� ��ū ���� : " + strToken.countTokens());
		int tokenCnt = strToken.countTokens();
		for (int i = 0; i < tokenCnt; i++) {
			//System.out.println("����� ��ū ���� : " + strToken.countTokens());
			String token = strToken.nextToken(); //��ū�� ���
			System.out.println("-" + token + "-");
		}
		
		System.out.println("======== ��ū���� ���ǻ��� ==========");
		// ������ ���� : �ݺ��� ������ 2�� �̻��� ��ū�� �� ���� ������� ����
		//    ����Ϸ��� �������� ���翩�� Ȯ�� �� ��� ����
//		strToken = new StringTokenizer(str, ",");
//		tokenCnt = strToken.countTokens();
//		for (int i = 0; i < tokenCnt; i++) {
//			System.out.println("-" + strToken.nextToken() + "-");
//			System.out.println("-" + strToken.nextToken() + "-");
//		}
		
		System.out.println("----- while ----");
		strToken = new StringTokenizer(str, ",");
		while (strToken.hasMoreTokens()) {
			System.out.println(strToken.nextToken());
			System.out.println(strToken.nextToken());
		}
	}

}










