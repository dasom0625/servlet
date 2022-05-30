package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1. 쿠키가 있는지 확인
		Cookie[] cookieArr = request.getCookies();
		
		//쿠키가 저장된게 하나도 없을떄,
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h2>저장된 쿠키가 없습니다.</h2>");
		}else {
			// 쿠키배열에서 삭제할 쿠키를 구한다. (보통 쿠키의 key값으로 확인)
			for(Cookie cookie : cookieArr) {
				String key = cookie.getName(); // '쿠키변수'값 구하기
				
				if("count".equals(key)) {	//삭제할 대상 찾기
					cookie.setMaxAge(0);//0으로 유지시간 설정하기 =>쿠키 정보가 바로 삭제되도록.
					response.addCookie(cookie);	//유지시간을 0으로 설정한 쿠키를 저장.
				}
			}
		}
		out.println("<h3>cookie가 초기화 되었습니다.</h3>");
		out.println("<a href = '"+request.getContextPath()+"/basic/cookie/cookieTest02.jsp'> 쿠키시작문서로 가기</a>");
		out.println("</body></html>");
		
		
	}

}
