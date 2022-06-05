<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>File Upload연습</h3>
<form action = "<%=request.getContextPath() %>/fileUpload.do" method = "post" enctype="multipart/form-data">
<!-- enctype="multipart/form-data" : 파일 전송할떄 쓰는 방식 -->
작성자 이름 : <input type = "text" name = "userName"><br><br>
한 개 파일 선택 : <input type = "file" name = "upFile1"><br><br>
여러개의 파일 선택 : <input type = "file" name = "upFile2" multiple><br><br>
<input type = "submit" value = "전송">
</form>
<br><hr><br>
<a href="<%=request.getContextPath() %>/fileList.do">파일 목록 보기</a>
</body>
</html>
