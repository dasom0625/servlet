package kr.or.ddit.basic.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.basic.fileupload.vo.FileInfoVO;

/*
	- Servlet3.0이상에서 파일 업로드를 하려면 서블릿에 @MultipartConfig 애노테이션을 설정해야한다.
	- @MultipartConfig애노테이션의 설정 변수들
		1) location : 업로드 한 파일이 임시적으로 저장 될 경로 지정(기본값 : "" --> 시스템의 임시폴더)
		2) fileSizeThreshold : 이 곳에 지정한 값보다 큰 파일이 전송되면 location에 지정한 폴더에 임시로 저장된다.
		 						=> 단위 : byte, 기본값 : 0(무조건 임시 디렉토리 사용)
		3) maxFileSize : 1개 파일의 최대크기
								=> 단위 : byte, 기본값 : -1L(무제한이라는 의미)
		4) maxRequestSize : 서버로 전송되는 request데이터 전체의 최대 크기
								=> 모든 파일 크기 + form Data
								=> 단위 : byte, 기본값 : -1L(무제한이라는 의미)

 */
@WebServlet("/fileUpload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,//1024 * 1024 * 10 => 10메가 라는 의미 
		maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100)
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//GET방식으로 호출할때는 fileUpload폼을 보여주는 jsp문서로 forwarding한다.
		request.getRequestDispatcher("/basic/fileupload/fileUpload.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//POST방식으로 호출할때는 클라이언트가 보낸 파일을 받아서 처리한다.
		request.setCharacterEncoding("utf-8");
		//업로드한 파일들이 저장될 폴더 설정하기
		String uploadPath = "D:/D_Other/java업로드파일uploadFiles";
		//저장된 폴드가 없으면 새로 만들기
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//file이 아닌 일반 데이터는 getParameter()메소드나 getParameterValues()메소드를 이용해서 구한다.
		String userName = request.getParameter("userName");
		System.out.println("일반 파라미터 데이터 : "+userName);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//전송되어 온 파일 데이터 처리하기
		String fileName = "";	//전송되어 온 파일의 이름(원래의 파일명)이 저장될 변수 선언
		
		//전송된 파일이 2개 이상일 경우에는 List객체에 파일 정보를 넣어서 처리하기 위한 List객체를 생성한다.
		List<FileInfoVO>fileList = new ArrayList<FileInfoVO>();
		
		/*
		-servlet 3.0이상에서 파일처리를 위해 추가된 메서드들
			1) request.getParts()	=> 전체 part객체를 Collection객체에 담아서 반환
			2) request.getPart("part이름")	=> 지정한 'part이름'을 가진 개별 part객체를 반환
		 */
		//전체 Part객체 개수만큼 반복처리하기
		for(Part part : request.getParts()) {
			
		}
		
	}
	
	/*
	-part객체의 구조
		1) 파일이 아닌 일반 데이터일 경우
		----------------ㅁㄴ아러;ㅣㅁㄴ아ㅓㄹ;ㅣㅏ먼;이ㅏ러 ==> Part를 구분하는 구분선(----)
		content-disposition: form-data; name="userName"	==> 파라미터명
														==> 빈줄 들어감
		hong											==>	파라미터 값
		
		2) 파일일 경우
		----------------ㅁㄴ아러;ㅣㅁㄴ아ㅓㄹ;ㅣㅏ먼;이ㅏ러 ==> Part를 구분하는 구분선(----)
		content-disposition: form-data; name="upFile1"; filename="test1.txt" ==> 파일정보
		content-type: text/plain											==> 파일의 종류
																			==> 빈줄 들어감
		빠이짜이찌엔사요나라														==>	파일 내용
														
	 */
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//part구조 안에서 파일명을 찾는 메서드
	private String extracFileName(Part part) {
		String fileName = "";
		
		
		
		return fileName;
	}

}
