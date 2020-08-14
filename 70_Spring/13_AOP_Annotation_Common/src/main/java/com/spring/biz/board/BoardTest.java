package com.spring.biz.board;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(vo);
		System.out.println("board : " + board);

	}

}
