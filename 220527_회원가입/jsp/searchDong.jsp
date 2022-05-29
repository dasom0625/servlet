<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//1. 서블릿(Resources pkg - kr.or.ddit.member.controller pkg - serachZip.java)에서 request에서 저장한 데이터를 가져온다.
List<ZipVO> list = (List<ZipVO>)request.getAttribute("dongResult");


if(list != null && list.size() > 0){	// list가 null이아니거나 0보다 크면 주소가 존재하니 출력하기

//2. 가져올 것...
%>
[
 
 <%
 for(int i = 0 ; i< list.size(); i++){
	 ZipVO vo = list.get(i);

	 String bunji = vo.getBunji();
	 if(bunji == null)bunji = "";	//bunji가 null일때 null이 아닌 공백이 출력되게 한다. 
	 
	 if(i>0) out.print(",");
	
 %>
 	{
 	"zipcode"	:	"<%=vo.getZipcode() %>",
 	"addr"		:	"<%=vo.getSido() %> <%=vo.getGugun() %> <%=vo.getDong() %>",
	"bunji"		:	"<%=bunji %>"
 	}
 
 <%
 }
 %>
 
 ]
<% 	
}else{//해당 주소가 존재하지 않아 출력할것이 없을떄
%>
	{"sw"	:	"입력하신 주소는 존재하지 않습니다."}

<%
}
%>
