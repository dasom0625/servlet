package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1. 쿠키가 있는지 확인
		Cookie[] cookieArr = request.getCookies();
		int count = 0;//방문 숫자 세어줄 변수 초기화
		
		//쿠키에 저장된게 하나라도 있을 때
		if(cookieArr!=null) {
			for(Cookie cookie : cookieArr) {
				String key = cookie.getName(); // '쿠키변수'값 구하기
				if("count".equals(key)) {	//증가시킬 대상 찾기
					// 현재의 count값 구하기
					count = Integer.parseInt(cookie.getValue());	//현재의 count값을 구한것.
					break;
				}
			}
		}
			count++;
			//증가된 count 값을 countCookie라는 객체를 생성해서 저장한다.
			Cookie countCookie = new Cookie("count", String.valueOf(count));
			response.addCookie(countCookie);//쿠키변수를 저장

			out.println("<html><head><meta charset='utf-8'>");
			out.println("<title>Cookie 연습</title></head>");
			out.println("<body>");
			out.println("<h2>어서요세요. 당신은 "+count+"번째 쿠키입니다.</h2><br><hr>");
			out.println("<a href = '"+request.getContextPath()+"/cookieCountServlet.do'>카운트 증가하기</a><br>");
			out.println("<a href = '"+request.getContextPath()+"/basic/cookie/cookieTest02.jsp'>쿠키시작문서로 가기</a>");
			out.println("</body></html>");
	}
}
