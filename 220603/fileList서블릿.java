package kr.or.ddit.basic.fileupload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.basic.fileupload.service.IFileInfoService;
import kr.or.ddit.basic.fileupload.vo.FileInfoVO;

@WebServlet("/fileList.do")
public class fileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	IFileInfoService service = FileInfoServiceImpl.getInstance();
	
	//DB애서 파일 목록을 가져와서 List에 저장하기
	List<FileInfoVO>fileList = service.getAllFileInfo();
	
	//만들어진 List객체를 View페이지(fileList.jsp)로 보낸다.
	request.setAttribute("fileList", fileList);
	
	request.getRequestDispatcher("/basic/fileupload/fileList.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
