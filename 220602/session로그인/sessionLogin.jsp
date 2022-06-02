//WebContent안의 jsp파일

<%@page import="kr.or.ddit.basic.session.MyMemberVO"%>
<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table{
border : 2px solid red;
margin-left : 40%;
margin-top : 250px;
}
tr,td{
padding : 10px;
text-align: center;
}
#in{
width: 100%;
height: 100%;
}
#btn{
text-align: center;
}
.t1{
width: 20px;
}

</style>
<title>sessionLogin연습</title>
</head>
<!-- MYMEMBER테이블에 저장된 회원ID와 Password로 로그인 처리를 하고, 환영 메시지는 회원이름이 출력되도록 수정하라. -->
<body>
<%
HttpSession ss = request.getSession();
MyMemberVO vo = (MyMemberVO)ss.getAttribute("success");

if(vo == null){	//세션이 존재 하지 않을때 (아이디와 비밀번호가 존재하지 않거나 일치하지 않을때?)
%>
<form action="<%=request.getContextPath() %>/sessionLogin.do" method="post">
<table border = "1">
	<tr>
		<td class = "t1">ID</td>
		<td><input id = "in" type="text" name = "id" value = "" placeholder="아이디를 입력하세요"></td>	
	</tr>
	<tr>
		<td class = "t1">PW</td>
		<td><input id = "in" type="text" name = "pw" value = "" placeholder="비밀번호를 입력하세요"></td>	
	</tr>
	<tr>
		<td id = "btn" colspan="2"><input type = "submit" value = "Login"></td>
	</tr>
</table>
</form>
<%
}else{
%>
<h2><%=vo.getMem_name() %>님 환영합니다.</h2>
<a href = "<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a><br><br>
<%	
}
%>
</body>
</html>
