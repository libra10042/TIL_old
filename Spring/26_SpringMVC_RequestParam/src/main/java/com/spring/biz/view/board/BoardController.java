package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	//리턴타입 ModelAndView -> String 변경
	//전달할 데이터 저장 타입 : ModelAndView -> Model
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, 
			Model model) {
		System.out.println(">>> 글 상세 - String getBoard()");
		
		BoardVO board = boardDAO.getBoard(vo);
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	//@RequestParam : 파라미터값을 메소드 파라미터 값으로 설정
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) 
			String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) 
			String keyword,
			BoardDAO boardDAO, Model model) {
		System.out.println(">>> 게시글 전체 목록 - String getBoardList()");
		
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardDAO.getBoardList(condition, keyword);
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 글 입력 - insertBoard()");
		
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 글 수정 - updateBoard()");
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 글 삭제 - deleteBoard()");
		
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
}
