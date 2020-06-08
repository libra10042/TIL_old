package com.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String db = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String id = "c##Inventory";
	private static final String pw = "0000";
	
	//������. ��ü ���� ����.
	private ConnectionManager() {}
	
	//�ʱ�ȭ ��. Ŭ���� �ε��� ����̹��� �ε� 
	static {
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//Connection ��ü�� �����ϴ� �޼ҵ�
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(db, id, pw);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
