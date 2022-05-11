package com.mystudy.ojdbc3_prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManager_Update {

	public static void main(String[] args) {
		//(�ǽ�) PreparedStatement ����ؼ� ���� �۾�
		// ������� : ID - DB�� �ִ� ������ ���
		// �̸�: ȫ�浿, ����: 100, ����: 90, ����: 81 ���� ����ó��

		//0. JDBC ���̺귯�� ����ȯ�� ����(�����ο� ���)
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC ����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			//3-1. Connection ��ü�κ��� PreparedStatement ��ü ����
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE STUDENT ");
			sql.append("   SET NAME = ? "); // 1 ���ε庯���� ��ġ��ȣ
			sql.append("     , KOR = ? ");   // 2
			sql.append("     , ENG = ? ");   // 3
			sql.append("     , MATH = ? ");  // 4
			sql.append(" WHERE ID = ? ");    // 5
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. ?(���ε庯��) ��ġ�� �� ����
			String id = "A3333";
			String name = "ȫ�浿P1111";
			int kor = 99;
			int eng = 88;
			int math = 77;
			
			pstmt.setString(1, name);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, math);
			pstmt.setString(5, id);
			
			//3-3. SQL�� ����
			int result = pstmt.executeUpdate();
			
			//4. SQL �������� ���� ó��
			System.out.println("ó���Ǽ� : " + result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�
			try {
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
