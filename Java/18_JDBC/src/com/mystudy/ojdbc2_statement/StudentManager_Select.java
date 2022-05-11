package com.mystudy.ojdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.BuildInfo;

public class StudentManager_Select {

	public static void main(String[] args) {
		//JDBC�� �̿��� DB ���α׷��� ���� 
		//0. JDBC ���̺귯�� ����ȯ�� ����(�����ο� ���)
		//1. JDBC ����̹� �ε�
		//2. DB����  - Connection ��ü ���� <- DriverManager
		//3. Statement�� ����(SQL�� ����)
		//4. SQL ���� ����� ���� ó��
		//   -SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
		//   -INSERT, UPDATE, DELETE : int��(�Ǽ�) ó��
		//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�
		//------------------------------------

		//0. JDBC ���̺귯�� ����ȯ�� ����(�����ο� ���)
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("--- ������ ��ȸ �۾� ���� ---");
		try {
			//1. JDBC ����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			//3-1. Connection ��ü�κ��� Statement ��ü ����
			stmt = conn.createStatement();
			
			String id = "A1111";
			StringBuilder sb = new StringBuilder();
			//columnIndex :   1   2     3    4    5     6    7
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sb.append("  FROM STUDENT ");
			sb.append(" WHERE ID = '" + id + "' ");
			System.out.println("SQL : " + sb);
			
			//3-2. SQL�� ����
			rs = stmt.executeQuery(sb.toString());
			
			//4. SQL ���� ����� ���� ó��
/*			
			while (rs.next()) {
				// String Ÿ���� �Һ� ������
				// ���ڿ� ���̱� �ϸ� ���ο� String ������ ����
				String str = "";
				str += rs.getString(1) + "\t";  
				str += rs.getString(2) + "\t";
				str += rs.getInt(3) + "\t";
				str += rs.getInt(4) + "\t";
				str += rs.getInt(5) + "\t";
				str += rs.getInt(6) + "\t";
				str += rs.getDouble(7);
				
				System.out.println(str);
			}
*/			
			while (rs.next()) {
				sb.setLength(0); //�ʱ�ȭ : ����� ���ڿ� ����
				int idx = 1;
				sb.append(rs.getString(idx++)).append("\t");
				sb.append(rs.getString(idx++)).append("\t");
				sb.append(rs.getInt(idx++)).append("\t");
				sb.append(rs.getInt(idx++)).append("\t");
				sb.append(rs.getInt(idx++)).append("\t");
				sb.append(rs.getInt(idx++)).append("\t");
				sb.append(rs.getDouble(idx++)).append("\t");
				
				System.out.println(sb.toString());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�
			try {
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--- ������ ��ȸ �۾� �� ---");
	}

}










