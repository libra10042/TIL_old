package com.spring.biz.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

@Controller
@SessionAttributes("board") //board 라는 이름의 Model이 있으면 session에 저장
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("--->> BoardController() 객체생성");
	}
	
	// 메소드에 선언된 @ModelAttribute 는 리턴된 데이터를 View에 전달
	// @ModelAttribute 선언된 메소드는 @RequestMapping 메소드보다 먼저 실행됨
	// 뷰에 전달될 때 설정된 명칭(예: conditionMap)으로 전달
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println(">>> @ModelAttribute - Map searchConditionMap()");
		// key: 제목, value: TITLE
		// key: 내용, value: CONTENT
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	//리턴타입 ModelAndView -> String 변경
	//전달할 데이터 저장 타입 : ModelAndView -> Model
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println(">>> 글 상세 - String getBoard()");
		
		BoardVO board = boardService.getBoard(vo);
		model.addAttribute("board", board);
		System.out.println("getBoard() board : " + board);
		
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println(">>> 게시글 전체 목록 - String getBoardList()");
		
		//검색조건 값 null체크 후 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println(">>> 글 입력 - insertBoard()");
		System.out.println("> insertBoard() vo : " + vo);
		
		/* 파일업로드 관련 처리
		 * MultipartFile 인터페이스 주요 메소드
		 * String getOriginalFilename() : 업로드한 파일명 찾기
		 * void transferTo(File dest) : 업로드할 파일을 업로드 처리
		 * boolean isEmpty() : 업로드 할 파일의 존재여부(없으면 true 리턴)
		 */
		MultipartFile uploadFile = vo.getUploadFile();
		System.out.println("> uploadFile : " + uploadFile);
		if (!uploadFile.isEmpty()) { //파일이 있으면(비어있지 않으면)
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("c:/MyStudy/temp/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//@ModelAttribute("board") : Model에 board라는 속성명의 객체가 있으면 사용
	//     없으면 board라는 이름으로 새로 생성
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println(">>> 글 수정 - updateBoard()");
		System.out.println("updateBoard() vo : " + vo);
		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println(">>> 글 삭제 - deleteBoard()");
		
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody //response 객체의 몸체(body)에 데이타 전달
	public List<BoardVO> dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("boardList : " + boardList);
		
		return boardList;
	}
	

}








