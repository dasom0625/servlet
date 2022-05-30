package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//cookie를 저장하는 방법
		/*
		1. Cookie객체를 생성한다. => '쿠키의 key값'과 '쿠키의 value값'은 문자열로 지정한다.(문자열만 가능)
			형식) Cookie cookie변수 = new Cookie("쿠키key값", "쿠키value값");
				=> '쿠키value값'으로 한글을 사용할 경우 URLEncoder.encode()메소드로 인코딩 한 후 저장한다.
		*/
		Cookie nameCookie = new Cookie("name",URLEncoder.encode("이다솜","utf-8"));
		int age = 31;
//		Cookie ageCookie = new Cookie("age", age+"31");	//age의 value값은 int이기떄문에 문자열로 바꿔줘야함.-방법 1
		Cookie ageCookie = new Cookie("age", String.valueOf(age));	//age의 value값은 int이기떄문에 문자열로 바꿔줘야함.-방법2
		Cookie genderCookie = new Cookie ("gender","Female");
		/*
		2. Cookie의 속성을 설정하기
			1) 쿠키변수.setPath("적용경로"); => 지정한 경로와 그 하위경로에서 사용 가능
		 						 	 	=> 생략하면 쿠키를 설정할 당시 경로가 기본값으로 설정됨.
		 	2) 쿠키변수.setMaxAge(유지시간); => 유지시간 단위 : 초.
		 								=> 유지시간을 -1로 설정시, 브라우저가 종료될때까지 유지(default값(기본값))
		 								=> 유지시간을 0으로 설정시, 즉시 삭제
		 	3) 쿠키변수.setDomain("적용도메인명"); => 도메인명을 어떻게 지정했느냐에 따라 다른곳에서도 지정한 도메인을 쓸 수 있음.		
		 								=> ex) ".ddit.or.kr" => www.ddit.or.kr, www2.ddit.or.kr이런식으로 쓸 수 있음.
		 	4) 쿠키변수.setSecure(보안여부)  => true : 적용 / false : 미적용
		 	
		 */
		/*
		3. Response객체를 이용하여 쿠키를 웹브라우저로 보내면, 웹브라우저가 이 쿠키를 받아서 저장한다.
			형식) response객체변수.addCookie(1번에서 만든 Cookie변수이름);
			
		 */
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Cookie데이터가 저장되었습니다.</h2><br><hr>");
		out.println("<a href = '"+request.getContextPath()+"/basic/cookie/cookieTest.jsp'> 쿠키시작문서로 가기</a>");
		out.println("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
