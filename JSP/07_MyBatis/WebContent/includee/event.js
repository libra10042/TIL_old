	function sel_all(frm) { //전체 데이터 조회
		frm.action = "selectAll.jsp";
		frm.submit();
	}
	function sel_one(frm) { //ID로 검색
		frm.action = "selectOneID.jsp"
		frm.submit();
	}
	function add_go(frm) { //데이터 입력
		if (frm.id.value.trim() == "") {
			alert("아이디(ID)는 필수 입력항목입니다.\n입력하세요");
			frm.id.value = "";
			frm.id.focus();
			return false;
		}
		frm.action = "insertMember.jsp";
		frm.submit();
	}
	function del_go(frm) {//데이터 삭제(ID 값으로)
		if (frm.id.value.trim() == "") {
			alert("삭제할 아이디(ID)는 필수 입력항목입니다.\n입력하세요");
			frm.id.value = "";
			frm.id.focus();
			return false;
		}
		frm.action = "deleteMember.jsp";
		frm.submit();
	}