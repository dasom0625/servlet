package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//Session삭제하기
		
		/*
		1. Session객체를 생성하거 현재 session가져오기
		2. Session객체.removeAttribute("key값");
			==> 세션 자체는 삭제되지 않고, 개별적인 세션 값만 삭제된다.
				(지정한 'key값'과 일치하는 세션 값 삭제)
		3. session객체.invalidate();세션 삭제
		 */

		//1.
		HttpSession session = request.getSession();
		
		//2.
		session.removeAttribute("testSession");
		//3.
		session.invalidate();
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Session 삭제</title></head>");
		out.println("<body>");
		out.println("<h2>Session 정보 삭제하기</h2>");
		
		out.println("<a href = '"+request.getContextPath()+ "/basic/session/sessionTest.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body><html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
