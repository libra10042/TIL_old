package com.myproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myproject.vo.Admin;
import com.myproject.vo.Member;


public class InventoryDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//회원 로그인 메뉴
	public boolean loginMember(Member vo) {
		boolean flag = false; 
		try{
			con = ConnectionManager.getConnection();
			String sql = "select * from member where id=? and pw=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				flag = true; 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return flag; 
	}
	
	
	//회원 등록
	public boolean insertMember(Member vo) {
		boolean result = true; 
		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into member values(?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			pstmt.setString(4, vo.getPw());
			int inserted = pstmt.executeUpdate();
			if(inserted==0) {
				return false; 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close(); 
				if(rs!=null) rs.close(); 
			}catch(SQLException e) {
				
			}
		}
	
		return result; 
	}
	
	//전체 회원 목록 확인.
	public ArrayList<Member> selectAllMember(){//전체 출력이라여 param 안받음. 
		ArrayList<Member> mList = new ArrayList<>();
		try {
			con = ConnectionManager.getConnection();
			String sql = "select no, name, id, pw from member";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				String no = rs.getString(1);
				String name = rs.getString(2);
				String id = rs.getString(3);
				String pw = rs.getString(4);
				
				mList.add(new Member(no, name, id, pw));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return mList; 
		
	}
	
	
	
	//관리자 등록. 
	public int insertAdmin(Admin vo) {
		int result = 0; 
		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into admin values(?,?,?,?,?,?)";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, vo.getAdminName());
			pstmt.setString(2, vo.getAdminId());
			pstmt.setString(3, vo.getAdminPw());
			pstmt.setString(4, vo.getAdminPhone());
			pstmt.setString(5, vo.getAdminAddress());
			pstmt.setString(6, vo.getNo());
			
			result = pstmt.executeUpdate(); 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close(); 
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close(); 
			}catch(SQLException e) {
				
			}
		}
		return result; 
	}
	
	
	//관리자 로그인 
	public boolean loginAdmin(Admin admin) {
		boolean flag = false; 
		try {
			con = ConnectionManager.getConnection();
			String sql = "select * from admin where ADMINID =? and ADMINPW = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getAdminId());
			pstmt.setString(2, admin.getAdminPw());
			ResultSet rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				flag = true; 
			}
			
	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close(); 
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException e) {
				
			}
		}
		return flag; 	
	}
	
	
	
	//회원 정보삭제
	public boolean deleteMember(String no) {//no를 하나만 받아온다.
		boolean result = true; 
		try {
			con = ConnectionManager.getConnection();
			String sql = "delete member where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			int deleted = pstmt.executeUpdate();
			if(deleted==0) {
				result = false; 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

	}


	

	//
	
	
	
	
//	
//	public int insertProduct(ProductVO vo) 
//	{
//		int result = 0;
//		
//		try 
//		{
//			con = ConnectionManager.getConnection();
//			String sql = "insert into com_product values(?,?,?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, vo.getCode());
//			pstmt.setString(2, vo.getPname());
//			pstmt.setInt(3, vo.getPrice());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) 
//		{
//			
//		} finally 
//		{
//			try {
//				if(con!=null)con.close();
//				if(pstmt!=null)pstmt.close();
//				if(rs!=null)rs.close();
//			} catch (SQLException e) {
//			}
//		}
//
//		return result;
//		
//	}
//	
//	
//	
//	public ArrayList<ProductVO> listProduct()
//	{
//		ArrayList<ProductVO> plist = new ArrayList<ProductVO>();
//		try 
//		{
//			con = ConnectionManager.getConnection();
//			String sql = "select * from com_product";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) 
//			{
//				String code = rs.getString(1);
//				String pname = rs.getString(2);
//				int price = rs.getInt(3);
//				
//				ProductVO temp = new ProductVO(code, pname, price);
//				
//				plist.add(temp);
//			}
//			
//		} catch (Exception e) 
//		{
//			
//			
//		} finally 
//		{
//			try {
//				if(con!=null)con.close();
//				if(pstmt!=null)pstmt.close();
//				if(rs!=null)rs.close();
//			} catch (SQLException e) {
//
//			}
//		}
//		
//		return plist;
//		
//	}
//	
//	
//	
//	public int insert(SalesVO vo)
//	{
//		int result = 0;
//		try 
//		{
//			con = ConnectionManager.getConnection();
//			String sql = "insert into com_sales(num,code,quantity) values(com_sales_seq.nextval,?,?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, vo.getCode());
//			pstmt.setInt(2, vo.getQuantity());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) 
//		{
//			
//			
//		} finally 
//		{
//			try {
//				if(con!=null)con.close();
//				if(pstmt!=null)pstmt.close();
//				if(rs!=null)rs.close();
//			} catch (SQLException e) {
//
//			}
//		}
//		
//		return result;
//		
//	}
//	
//	
//	public ArrayList<SalesVO> list()
//	{
//		ArrayList<SalesVO> slist = new ArrayList<SalesVO>();
//		
//		try 
//		{
//			con = ConnectionManager.getConnection();
//			String sql = "select num,to_char(inputdate,'YY.MM.DD'),code,quantity from com_sales order by num asc";
//			pstmt = con.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) 
//			{
//				int num = rs.getInt(1);
//				String inputdate = rs.getString(2);
//				String code = rs.getString(3);
//				int quantity =rs.getInt(4);
//				
//				SalesVO temp = new SalesVO(num, inputdate, code, quantity);
//				
//				slist.add(temp);
//			}
//			
//			
//		} catch (Exception e) 
//		{
//			
//			
//		} finally 
//		{
//			try {
//				if(con!=null)con.close();
//				if(pstmt!=null)pstmt.close();
//				if(rs!=null)rs.close();
//			} catch (SQLException e) {
//
//			}
//		}
//		
//		return slist;
//		
//	}
//	
//	
//	
//	public int update(SalesVO vo)
//	{
//		int result = 0;
//		
//		try 
//		{
//			con = ConnectionManager.getConnection();
//			String sql = "update com_sales set quantity = ? where num = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, vo.getQuantity());
//			pstmt.setString(2, vo.getCode());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) 
//		{
//			
//			
//		} finally 
//		{
//			try {
//				if(con!=null)con.close();
//				if(pstmt!=null)pstmt.close();
//				if(rs!=null)rs.close();
//			} catch (SQLException e) {
//
//			}
//		}
//		
//		return result;
//		
//	}
//	
//	
//	
//	public int delete(int num)
//	{
//		int result = 0;
//		
//		try 
//		{
//			con = ConnectionManager.getConnection();
//			String sql = "delete com_sales where num = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			
//			result = pstmt.executeUpdate();
//		} catch (Exception e) 
//		{
//			
//		} finally 
//		{
//			try {
//				if(con!=null)con.close();
//				if(pstmt!=null)pstmt.close();
//				if(rs!=null)rs.close();
//			} catch (SQLException e) {
//
//			}
//		}
//		
//		return result;
//		
//	}
//	
//	
//	
//	public  ArrayList<SalesListVO> sales()
//	{
//		ArrayList<SalesListVO> slist = new ArrayList<SalesListVO>();
//		ArrayList<ProductVO> plist = new ArrayList<ProductVO>();
//		
//		try 
//		{
//			con = ConnectionManager.getConnection();
//			String sql = "select code,sum(quantity) from com_sales group by code";
//			pstmt = con.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) 
//			{
//				String code = rs.getString(1);
//				int quantity = rs.getInt(2);
//				
//				SalesListVO vo = new SalesListVO();
//				vo.setCode(code);
//				vo.setQuantity(quantity);
//				slist.add(vo);
//			}
//			
//			plist = listProduct();
//			
//			for (int i = 0 ; i < slist.size() ; i++) 
//			{
//				for(int j = 0; j<plist.size(); j++) 
//				{
//					if(slist.get(i).getCode().equals(plist.get(j).getCode())) 
//					{
//						slist.get(i).setPname(plist.get(j).getPname());
//						
//						int total = slist.get(i).getQuantity() * plist.get(j).getPrice();
//						
//						slist.get(i).setSaleAmount(total);
//						
//					}
//				}
//			}
//			
//			
//		} catch (Exception e) 
//		{
//			
//			
//		} finally 
//		{
//			try {
//				if(con!=null)con.close();
//				if(pstmt!=null)pstmt.close();
//				if(rs!=null)rs.close();
//			} catch (SQLException e) {
//
//			}
//		}
//		
//		return slist;
//		
//	}
//
//	
//	
//	
		


