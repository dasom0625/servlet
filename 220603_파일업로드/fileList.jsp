<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.basic.fileupload.vo.FileInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//서블릿에서 보낸 자료 받기(fileList.java서블릿)
	List<FileInfoVO> fileList = (List<FileInfoVO>)request.getAttribute("fileLIst");
%>
<h3>[ 전체 파일 목록 ]</h3>
<br><hr><br>
<a href = "<%=request.getContextPath() %>/fileUpload.do">파일 업로드 하기</a>
<table border = "1">
<tr>
	<th>번호</th>
	<th>작성자</th>
	<th>저장파일명</th>
	<th>원래파일명</th>
	<th>파일 크기</th>
	<th>날짜</th>
	<th>비고</th>
</tr>
<%
	if(fileList == null || fileList.size()==0) {
%>
<tr>
	<td colspan="7">저장된 파일이 하나도 없습니다.</td>
</tr>

<%	
}else{
	for(FileInfoVO vo : fileList){
%>

<tr>
	<td><%=vo.getFile_no() %></td>
	<td><%=vo.getFile_writer() %></td>
	<td><%=vo.getSave_file_name() %></td>
	<td><%=vo.getOrigin_file_name() %></td>
	<td><%=vo.getFile_size() %></td>
	<td><%=vo.getFile_date() %></td>
	<td>DownLoad</td>
</tr>	

<%}%>

</table>
</body>
</html>
