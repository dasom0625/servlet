package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionRead.do")
public class SsesionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1. 저장된 Session읽어오기
		
		//1-1. Session객체를 생성하거나  현재 Session가져오기.
		HttpSession session = request.getSession();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Session 읽기</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Session 데이터 확인하기</h2>");
		out.println("<h3>Session 데이터 1개 확인하기</h3>");
		
		/*
		 2. Session객체의 getAttribute()메소드를 이용하여 저장된 Session값을 읽어온다. 
			형식) sessionrorcp.getAttribute("key값");
		 */
		String sessionValue = (String) session.getAttribute("testSession");	//만약 여기서 key값이 없으면 value값이 null이 나온다.
		if(sessionValue == null) {	//sessionValue 가 null값이면?
			out.println("<h3>testSession의 세션값이 없습니다.</h3>");
		}else {	//sessionValue 이 null이 아니라 값이 있으면?
			out.println("<h3>testSession 값 : " + sessionValue +"</h3>");
		}
		out.println("<hr>");
		out.println("<h3>전체 세션 데이터 확인하기</h3>");
		out.println("<ol>");
		
		/*
		3. Session의 전체 key값을 가져오는 메소드 
			=> session객체의 getAttributeNames()메소드 이용
			=> 반환값 : Enumeration (Iterator와 비슷)
		 */
		Enumeration<String> sessionNames = session.getAttributeNames();
		
		int cnt = 0;
		while(sessionNames.hasMoreElements()) {//다음 Enumeration이 있냐??
			cnt++;
			String sessionKey = sessionNames.nextElement(); //다음 Enumeration이 있으면 session의 key 값 구하기
			out.println("<li>"+sessionKey + " : " 
			+ session.getAttribute(sessionKey)+"</li>"); //있으면 값 넘겨주기
			
		}
		if(cnt==0) {
			out.println("세션 데이터가 하나도 없는데요...?");
		}
	
		out.println("</ol>");
		
		out.println("<hr>");
		
		/*
		 세션ID ==> 세션을 구분하기 위한 고유한 값
		사람이 서버에 접속하면 난수의 세션ID가 생성되고, 
		그 값을 클라이언트 쿠키에 저장해주고, 
		클라이언트가 쿠키로 가져왔던 session아이디를 가져와서 그걸 연결하여 처리해줌.
		DB로 비유하자면 PK와 같은것이다.
		 */
		out.println("세션ID : "+session.getId()+"<br>");

		/*
		세션 생성시간 ==> 1970년1월1일부터 경과한 시간으로, 밀리세컨드 단위로 출력된다.
		 */
		out.println("세션 생성시간 : "+session.getCreationTime()+"<br>");
		/*
		세션 최근 접근 시간 ==>
		 */
		out.println("새션 최근 접근 시간 :" + session.getLastAccessedTime()+"<br>");
		/*
		세션 유호 시간
		==> 단위 : 초
		==> 세션이 유지되는 시간
		==> 세션을 계속 접근하면 최근 접근시간으로 리셋되면서 계속 유효시간을 갱신하지만, 세션을 사용하지않으면 유효시간이 다되어 삭제된다.
		==> 유효시간 설정은 session.setMaxInactiveInterval(초단위시간);
		 */
		out.println("세션 유효 시간 : "+ session.getMaxInactiveInterval()+"<br>");
		out.println("<a href = '"+request.getContextPath()+ "/basic/session/sessionTest.jsp'> 시작 문서로 이동하기</a>");
		
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
