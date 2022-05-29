package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

@WebServlet("/searchZip.do")
public class searchZip extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1. 요청시 전송데이터 받기=>searchDong.html파일에서 data : {"dong" : dvalue}에서 dong가져오기
	String userDong = request.getParameter("dong");
	//2. service객체 생성
	IMemberService service = MemberServiceImpl.getInstance();
	//3. service메소드 호출 -걸과값 받기
	List<ZipVO> listDong = service.selectByDong(userDong);
	//4. request객체에 결과값을 저장
	request.setAttribute("dongResult", listDong);
	//5. 결과값 출력 - view페이지로 이동(foward사용)
	request.getRequestDispatcher("0525/searchDong.jsp").forward(request, response);	

	}

}
