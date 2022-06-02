//로그인 서블릿 파일

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

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession ss = request.getSession();
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		MyMember mm = new MyMember();		
		
		//입력받은id와 pw를 MyMemberVO에 담기
		MyMemberVO vo = new MyMemberVO();
		vo.setMem_id(userID);
		vo.setMem_pw(userPW);
		//DB에 있는 아이디와 비밀번호 불러오기
		MyMemberVO callvo = mm.loginID(vo);
		
		if(callvo != null) {	//DB에 존재하는 아이디와 비번이면 callvo를 담아서 sessionLogin.jsp로 같이 보내기
			ss.setAttribute("success", callvo);
			response.sendRedirect(request.getContextPath()+"/basic/session/sessionLogin.jsp");
			
		}else {	//DB에 존재하지 않으면?
			response.sendRedirect(request.getContextPath()+"/basic/session/sessionLogin.jsp");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
