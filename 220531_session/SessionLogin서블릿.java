package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//Session객체를 생성하거나 현재 Session가져오기
		HttpSession ss = request.getSession();
		String id =  request.getParameter("id");
		String pw =  request.getParameter("pw");
		
		//id : test / pw : 1234 일치 여부  
		if(id.equals("test")&&pw.equals("1234")) {//아이디, 비번이 맞으면?
			ss.setAttribute("id", id);
			out.println("admin님 환영합니다<br><br>");
			
			out.println("<a href = '"+request.getContextPath()+ "/sessionLogout.do'>로그아웃</a>");
		}else {
			response.sendRedirect(request.getContextPath()+"/basic/session/sessionLogin.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
