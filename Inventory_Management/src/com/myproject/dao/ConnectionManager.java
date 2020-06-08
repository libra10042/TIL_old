package com.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String db = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String id = "c##Inventory";
	private static final String pw = "0000";
	
	//생성자. 객체 생성 금지.
	private ConnectionManager() {}
	
	//초기화 블럭. 클래스 로딩시 드라이버도 로딩 
	static {
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//Connection 객체를 리턴하는 메소드
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
