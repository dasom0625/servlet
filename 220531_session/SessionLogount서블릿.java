package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogout.do")
public class SessionLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text;html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1.현재 session가져오기
		HttpSession ss = request.getSession();
		
		//2. 삭제하기
		ss.removeAttribute("id");
		ss.removeAttribute("pw");
		
		//3. session객체.invalidate()세션삭제
		ss.invalidate();
		
		response.sendRedirect(request.getContextPath()+"/basic/session/sessionLogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
