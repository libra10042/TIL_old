package com.mystudy.ex03_sungjuk;

//���� ����� ����(Exception) �����
// SungjukProcessException ���� Ŭ������ ��� Ȯ���ؼ� �����(�׷����ؼ� ���� ����)
public class JumsuOutOfRangeException extends SungjukProcessException {
	public JumsuOutOfRangeException() {
		super("��������(0~100)�� ��� ���Դϴ�.");
	}
}
