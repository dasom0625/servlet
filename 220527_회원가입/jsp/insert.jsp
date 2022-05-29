<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//서블릿에서 저장된 공유데이터 가져오기(서블릿 파일 : controller폴더에 있는 InsertMember.java파일)
String id = (String)request.getAttribute("servletUserId");

if(id != null){
	

%>

	{	"sw"	:	"<%=id %>님 환영합니다."		}

<%
}else{ 
%>

	{	"sw"	:	"가입실패!"	}


<%
} 
%>



