package com.mystudy.ojdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Select {

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
		//==========================================

		//0. JDBC ���̺귯�� ����ȯ�� ����(�����ο� ���)
		//1. JDBC ����̹� �ε�
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> ����̹� �ε� ����~~~");
		} catch (ClassNotFoundException e) {
			System.out.println("[����] ����̹� �ε� ����!!!");
			e.printStackTrace();
		}

		//2. DB����  - Connection ��ü ���� <- DriverManager
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", 
					"mystudy", "mystudypw");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. Statement�� ����(SQL�� ����)
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//3-1. Connection ��ü�κ��� Statement ��ü ���� 
			stmt = conn.createStatement();
			
			//3-2. Statement ��ü ����� SQL �ۼ�
			String sql = ""
					+ "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG "
					+ "  FROM STUDENT"
					+ " ORDER BY NAME";
			
			//3-3. Statement ��ü ��� SQL ����
			rs = stmt.executeQuery(sql); //SELECT : executeQuery() ���
			
			//4. SQL ���� ����� ���� ó��
			//   -SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
			//   -INSERT, UPDATE, DELETE : int��(�Ǽ�) ó��
			System.out.println(">> SELECT  ��� ó��(ȭ�����) ------");
/*			
			while (rs.next()) {
				System.out.print(rs.getString("ID") + "\t");
				System.out.print(rs.getString("NAME") + "\t");
				System.out.print(rs.getInt("KOR") + "\t");
				System.out.print(rs.getInt("ENG") + "\t");
				System.out.print(rs.getInt("MATH") + "\t");
				System.out.print(rs.getInt("TOT") + "\t");
				System.out.println(rs.getDouble("AVG"));
			}
*/
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				sb.append(rs.getString("ID") + "\t");
				sb.append(rs.getString("NAME") + "\t");
				sb.append(rs.getInt("KOR") + "\t");
				sb.append(rs.getInt("ENG") + "\t");
				sb.append(rs.getInt("MATH") + "\t");
				sb.append(rs.getInt("TOT") + "\t");
				sb.append(rs.getDouble("AVG"));
				System.out.println(sb.toString());
				
				sb.setLength(0); //����� ���ڿ� ���� ó��
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�(��ü ���� ������ �������� ����)		
		System.out.println("--- main() �� ---");
		try {
			if (rs != null) rs.close();
			System.out.println(">> ResultSet close ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	}

}













