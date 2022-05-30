package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieRead.do")
public class CookieRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//쿠키 정보 읽어오기
		
		/*
		1. 전체 쿠키 정보를 Request객체를 통해서 가져온다. => 가져온 쿠키 정보들은 배열에 저장된다.
		 	형식) Cookie[] 쿠키배열 변수 = request객체변수.getCookies();		=>getCookies가 이 쿠키에 저장된 정보들을 모두 가져오라는 뜻
		 */
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Cookie 정보 확인하기/h2><hr>");
		
		//저장된 쿠키가 없을떄,
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h2>저장된 cookie가 없습니다. </h2>");
		}
		
		//2. 쿠키배열에서 해당 쿠키 정보를 구해오기
		for(Cookie cookie : cookieArr) {
			String key = cookie.getName();	//cookie의 key값을 구해옴.
			String value = URLDecoder.decode(cookie.getValue(),"utf-8");	//cookie의 value의 값을 가져오며, vlaue값이 한글일수 있으므로 인코딩해주기
			
			out.println("쿠키의 key값 : "+ key + "<br>");
			out.println("쿠키의 value값 : "+ value + "<br><hr>");
		
		}
		
		out.println("<a href = '"+request.getContextPath()+"/basic/cookie/cookieTest.jsp'> 쿠키시작문서로 가기</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
