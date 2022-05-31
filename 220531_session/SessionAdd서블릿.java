package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		[ Session ]
		1. Session 정보 저장하기
			1) Session객체를 생성하거나 현재 ssession가져오기
				형식1) Reqeust객체.getSession();또는 Reques객체.getSession(true);
					==> 현재 세션이 존재하면 현재 세션 반환
					==> 현재 세션이 존재하지 않으면 새로운 세션 생성
				형식2) Reqeust객체.getSession(false);
					==> 현재 세션이 존재하면 현재 세션은 반환
					==> 현재 세션이 존재하지 않으면 null을 반환
		
		2. Session객체의 setAtrribute()메소드를 이용하여 저장하기
				형식 ) session객체.setAttribute("key값", session값);
					==> "key값" : 문자열만 가능 / session값 : 모든 종류의 데이터를 사용 가능
		 */

		//1. Session정보 저장하기-> 형식1)의 방법을 사용
		HttpSession session = request.getSession();
		
		//2. Session객체의 setAtrribute()메소드를 이용하여 저장하기 =>수량 관련없이 계속 저장 가능! 
		session.setAttribute("testSession", "연습용 세션입니다.");
		session.setAttribute("userName", "allCotton");
		session.setAttribute("userAge", 31);
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Session 저장</title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터가 저장되었습니다.</h2><br><br>");
		out.println("<a href = '"+request.getContextPath()+ "/basic/session/sessionTest.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
