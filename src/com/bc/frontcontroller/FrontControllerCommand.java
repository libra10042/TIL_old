package com.bc.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.command.CardChkCommand;
import com.bc.command.Command;
import com.bc.command.GoMypageCommand;
import com.bc.command.InsertProduct2Command;
import com.bc.command.InsertProduct3Command;
import com.bc.command.InsertProductCommand;
import com.bc.command.MyBoardCommand;
import com.bc.command.MyPointCommand;
import com.bc.command.OrderCommand;
import com.bc.command.RegisterCommand;
import com.bc.command.SellerRegisterCommand;
import com.bc.command.ShopRegisterCommand;
import com.bc.command.ViewCommand;
import com.bc.command.ViewSellerCommand;
import com.bc.command.WriteCommand;
import com.bc.command.addCartlistCommand;
import com.bc.command.delCartlistCommand;
import com.bc.command.deleteAllCommand;
import com.bc.command.directBuyCommand;
import com.bc.command.editQuanCommand;
import com.bc.command.goOrderlistCommand;
import com.bc.command.loginChkCommand;
import com.bc.command.productlistCommand;
import com.bc.command.viewCartlistCommand;
import com.bc.command.writeQnaCommand;
import com.bc.command.writeQnaOkCommand;
import com.bc.command.writeReviewCommand;
import com.bc.command.writeReviewOkCommand;

@WebServlet("/controller")
public class FrontControllerCommand extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청에 대한 처리
		String type = request.getParameter("type");
		Command command = null;
		
//------------------------------------------------민형----------------------------------------------------------
		if ("order".equals(type)) {
			command = new OrderCommand();
		} else if ("view".equals(type)) {
			command = new ViewCommand();
		} else if ("write".equals(type)) {
			command = new WriteCommand();
		} else if("cardChk".equals(type)) {
			command = new CardChkCommand();
		} else if("goMypage".equals(type)) {
			command = new GoMypageCommand(); 
		} else if("myPoint".equals(type)) {
			command = new MyPointCommand();
		} else if("myBoard".equals(type)) {
			command = new MyBoardCommand();
//------------------------------------------------실----------------------------------------------------------
		} else if("productlist".equals(type)) {
			command = new productlistCommand();
		} else if("addCartlist".equals(type)) {
			command = new addCartlistCommand();
		} else if("viewCartlist".equals(type)) {
			command = new viewCartlistCommand();
		} else if("editQuan".equals(type)) {
			command = new editQuanCommand();
		} else if("delCartlist".equals(type)) {
			command = new delCartlistCommand();
		} else if("deleteAll".equals(type)) {
			command = new deleteAllCommand();
		} else if("loginChk".equals(type)) {
			command = new loginChkCommand();
		} else if("writeQna".equals(type)) {
			command = new writeQnaCommand();
		} else if("writeQna_ok".equals(type)) {
			command = new writeQnaOkCommand();
		} else if("writeReview".equals(type)) {
			command = new writeReviewCommand();
		} else if("writeReview_ok".equals(type)) {
			command = new writeReviewOkCommand();
		} else if("goOrderlist".equals(type)) {
			command = new goOrderlistCommand();
		} else if("directBuy".equals(type)) {
			command = new directBuyCommand();
//------------------------------------------------은영----------------------------------------------------------
		} else if("register".equals(type)) {
			command = new RegisterCommand();
//------------------------------------------------충진----------------------------------------------------------
		} else if("viewSeller".equals(type)) {
			command = new ViewSellerCommand();
		} else if("sellerRegister".equals(type)) {
			command = new SellerRegisterCommand();
		} else if("shopRegister".equals(type)) {
			command = new ShopRegisterCommand();
		} else if("insertProduct".equals(type)) {
			command = new InsertProductCommand();
		} else if("insertProduct2".equals(type)) {
			command = new InsertProduct2Command();
		} else if("insertProduct3".equals(type)) {
			command = new InsertProduct3Command();
		}
		String path = command.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
}
