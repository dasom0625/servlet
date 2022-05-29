<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/////////////////////////////////////////idCheck의 중복검사 페이지.=>JSON사용.///////////////////////////////////////////////////

//1. 서블릿에서 request에 저장한 데이터를 가져온다.
 String str = (String)request.getAttribute("idResult");	//idCheck.java파일에서 request.setAttribute의 key값으로 지정한것

 //2. str속에는..
 if(str == null){//null이면 사용 가능(id가 존재하지 않으니까 회원가입가능)
%>

	{"sw" : "사용 가능한 아이디"}


<%	 
 }else{//null이 아니면 사용 불가능 (id가 이미 존재하므로 회원가입불가)
%>

	{"sw" : "사용 불가능한 아이디"}

<%	 
 }//else끝
%>
