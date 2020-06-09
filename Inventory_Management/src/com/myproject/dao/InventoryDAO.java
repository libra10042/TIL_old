package com.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myproject.vo.Member;
import com.myproject.vo.Product;
import com.myproject.vo.Sales;
import com.myproject.vo.SalesList;

public class InventoryDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	
	//-----------------------회원 등록 & 회원 로그인 페이지--------------------------
	
	// 회원 로그인
	public boolean login(Member vo) {
		boolean result = false;

		try {
			con = ConnectionManager.getConnection();
			String sql = "select * from member where userId=? and userPw =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true; 
			}
			
			
		} catch (Exception e) {

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
			}
		}

		return result;

	}

	

	// 회원 가입
	public boolean insertMember(Member vo) {
		boolean flag = false;
		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into member values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddrees());
			pstmt.setString(5, vo.getPhone());
			int inserted = pstmt.executeUpdate();
			
			if(inserted==1) {
				flag = true;
			}
			
			
		} catch (Exception e) {

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
			}
		}

		return flag;

	}

	//--------------------------판매자 페이지---------------------------
	// 상품 등록
	public int insertProduct(Product vo) {
		int result = 0;

		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into product values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getPname());
			pstmt.setInt(3, vo.getPrice());

			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
			}
		}

		return result;

	}

	// 상품 전체 보기
	public ArrayList<Product> listProduct() {
		ArrayList<Product> plist = new ArrayList<Product>();
		try {
			con = ConnectionManager.getConnection();
			String sql = "select * from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String code = rs.getString(1);
				String pname = rs.getString(2);
				int price = rs.getInt(3);

				Product temp = new Product(code, pname, price);

				plist.add(temp);
			}

		} catch (Exception e) {

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {

			}
		}

		return plist;

	}

	// 판매 정보 등록
	public int insert(Sales vo) {
		int result = 0;
		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into sales(num,code,quantity) values(sales_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setInt(2, vo.getQuantity());

			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {

			}
		}

		return result;

	}

	// 판매 정보 전체보기
	public ArrayList<Sales> list() {
		ArrayList<Sales> slist = new ArrayList<Sales>();

		try {
			con = ConnectionManager.getConnection();
			String sql = "select num,to_char(inputdate,'YY.MM.DD'),code,quantity from sales order by num asc";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int num = rs.getInt(1);
				String inputdate = rs.getString(2);
				String code = rs.getString(3);
				int quantity = rs.getInt(4);

				Sales temp = new Sales(num, inputdate, code, quantity);

				slist.add(temp);
			}

		} catch (Exception e) {

		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {

			}
		}

		return slist;

	}

	// 판매정보 수정
	public int update(Sales vo) {
		int result = 0;

		try {
			con = ConnectionManager.getConnection();
			String sql = "update sales set quantity = ? where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getQuantity());
			pstmt.setString(2, vo.getCode());

			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {

			}
		}

		return result;

	}

	// 판매정보삭제
	public int delete(int num) {
		int result = 0;

		try {
			con = ConnectionManager.getConnection();
			String sql = "delete sales where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			result = pstmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {

			}
		}

		return result;

	}

	// 상품별 판매현황
	public ArrayList<SalesList> sales() {
		ArrayList<SalesList> slist = new ArrayList<SalesList>();
		ArrayList<Product> plist = new ArrayList<Product>();

		try {
			con = ConnectionManager.getConnection();
			String sql = "select code,sum(quantity) from sales group by code";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String code = rs.getString(1);
				int quantity = rs.getInt(2);

				SalesList vo = new SalesList();
				vo.setCode(code);
				vo.setQuantity(quantity);
				slist.add(vo);
			}

			plist = listProduct();

			for (int i = 0; i < slist.size(); i++) {
				for (int j = 0; j < plist.size(); j++) {
					if (slist.get(i).getCode().equals(plist.get(j).getCode())) {
						slist.get(i).setPname(plist.get(j).getPname());

						int total = slist.get(i).getQuantity() * plist.get(j).getPrice();

						slist.get(i).setSaleAmount(total);
					}
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {

			}
		}
		return slist;
	}
}
