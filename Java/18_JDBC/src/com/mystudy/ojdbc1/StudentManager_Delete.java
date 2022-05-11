package com.mystudy.ojdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Delete {
	
	public static void main(String[] args) {
		//JDBC�� �̿��� DB ���α׷��� ���� ------------------------------
		//0. JDBC ���̺귯�� ����ȯ�� ����(�����ο� ���)
		//1. JDBC ����̹� �ε�
		//2. DB����  - Connection ��ü ���� <- DriverManager
		//3. Statement�� ����(SQL�� ����)
		//4. SQL ���� ����� ���� ó��
		//   -SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
		//   -INSERT, UPDATE, DELETE : int��(�Ǽ�) ó��
		//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�
		//------------------------------------
		
		System.out.println("---- main() ���� ---");
		//0. JDBC ���̺귯�� ����ȯ�� ����(�����ο� ���)
		//1. JDBC ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("[����] ����̹� ���� ����");
			//e.printStackTrace();
		}
		
		//2. DB����  - Connection ��ü ���� <- DriverManager
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			System.out.println(">> DB ���� ����!!!");
		} catch (SQLException e) {
			System.out.println("[����] DB���� ����~~~");
			e.printStackTrace();
		}
		
		//3. Statement�� ����(SQL�� ����)
		Statement stmt = null;
		try {
			//3-1. Connetion ��ü�� ���� Statement ��ü ����
			stmt = conn.createStatement();
			
			//3-2. Statement ��ü���� ����� SQL�� �ۼ�
			String sql = ""
					+ "DELETE FROM STUDENT WHERE ID = '1111'";
			
			//3-3. Statement ��ü ����ؼ� SQL�� ����
			//INSERT, UPDATE, DELETE : executeUpdate() �޼ҵ� ��� ����
			//SELECT : executeQuery() �޼ҵ� ���
			int result = stmt.executeUpdate(sql); //���ϰ��� ó���Ǽ� 
			
			//4. SQL ���� ����� ���� ó��
			//   -SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
			//   -INSERT, UPDATE, DELETE : int��(�Ǽ�) ó��
			System.out.println("ó���Ǽ� : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�(��ü ���� �������� ����)
		try {
			if (stmt != null)stmt.close();
			System.out.println(">> Statement close ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
			System.out.println(">> Connection close ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("---- main() �� ---");
	}

}







