<%@page import="com.bc.mybatis.DAO"%>
<%@page import="com.bc.mybatis.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 현재 페이지에 표시할 데이터를 화면에 표시 
	1. 페이징 처리를 위한 객체(Paging) 생성해서 필요한 데이터 참조
	2. 페이징 객체에 설정할 데이터 저장 
	3. (DB) 전체데이터 조회
	4. (DB) 현재페이지에 표시할 데이터 조회
	5. 데이터 화면에 표시(화면컨트롤-스타일 설정)
--%>
<%
	//페이징 처리를 위한 Paging 객체 생성해서 값 읽고 설정
	Paging p = new Paging();

	//1. 전체 게시물의 수를 구하기
	p.setTotalRecord(DAO.getTotalCount());
	p.setTotalPage();
	System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
	System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
	
	//2. 현재 페이지 구하기
	String cPage = request.getParameter("cPage");
	if (cPage != null) {
		p.setNowPage(Integer.parseInt(cPage));
	}
	
	//3. 현재 페이지에 표시할 게시글 시작번호(begin), 끝번호(end) 구하기
	p.setEnd(p.getNowPage() * p.getNumPerPage()); //현재페이지번호 * 페이지당글수
	p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
	
	//(선택적) 3-1 끝 글번호가 데이터건수보다 많아지면 데이터 건수와 동일한 번호로 설정
	if (p.getEnd() > p.getTotalRecord()) {
		p.setEnd(p.getTotalRecord());
	}
	System.out.println("-----------");
	System.out.println(">>현재페이지 : " + p.getNowPage());
	System.out.println(">>시작번호(begin) : " + p.getBegin());
	System.out.println(">>끝번호(end) : " + p.getEnd());
	
	//---- 블록(block) 계산하기 -----------
	//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBS</title>
<style>
	#bbs table {
		width: 580px;
		margin-left: 10px;
		border-collapse: collapse;
		font-size: 14px;
	}
	#bbs table caption {
		font-size: 20px;
		font-weight: bold;
		margin-bottom: 10px;
	}
	#bbs table th, #bbs table td {
		text-align: center;
		border: 1px solid black;
		padding: 4px 10px;
	}
	#bbs .align-left { text-align: left; }
	
	.title { background-color: lightsteelblue; }
	
	.no { width: 15%; }
	.writer { width: 15%; }
	.regdate { width: 20%; }
	.hit { width: 15%; }
	
	/***** 페이지 표시 부분 스타일(시작) ****/
	.paging { list-style: none; }
	.paging li {
		float: left;
		margin-right: 8px;
	}
	.paging li a {
		text-decoration: none;
		display: block;
		padding: 3px 7px;
		border: 1px solid #00B3DC;
		font-weight: bold;
		color: black;
	}
	.paging .disable {
		border: 1px solid silver;
		padding: 3px 7px;
		color: silver;
	}
	.paging .now {
		border: 1px solid #ff4aa5;
		padding: 3px 7px;
		background-color: #ff4aa5;
	}
	.paging li a:hover {
		background-color: #00B3DC;
		color: white;
	}
	/***** 페이지 표시 부분 스타일(끝) ****/
</style>
</head>
<body>

<div id="bbs">
<table>
	<caption>게시글 목록</caption>
	<thead>
		<tr class="title">
			<th class="no">번호</th>
			<th class="subject">제목</th>
			<th class="writer">글쓴이</th>
			<th class="regdate">날짜</th>
			<th class="hit">조회수</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>10</td>
			<td class="align-left">게시글10</td>
			<td>홍길동</td>
			<td>2020-07-17</td>
			<td>10</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="4">
				<ol class="paging">
					<li class="disable">이전</li>
					<li><a href="#">1</a></li>
					<li class="now">2</li>
					<li><a href="#">3</a></li>
					<li><a href="#">다음</a></li>
				</ol>
			</td>
			<td>
				<input type="button" value="글쓰기">
			</td>
		</tr>
	</tfoot>
</table>

</div>



	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












