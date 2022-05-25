//20220525

/*
 [ Servlet ]
 
 1. 컨테이너에 의해 관리되는 자바기반 웹 컴포넌트로써, 동적인인 웹 컨테츠 생성을 가능하게 하는 기술이다.
 	=> URL주소 : servlet을 실행시킬 URL주소
 	 			ex) http://localhost:80/webTest/servletTest01.do
  					- http 				: 프로토콜
  					- localhost 		: 컴퓨터 이름 or 도메인명 or IP주소
					- 80				: 포트번호(포트번호가 80번일 경우 생략 가능)
					- /webTest			: 컨텍스트 패스 (보통은 '프로젝트명'으로 설정된다)
					- /servletTest01.do : 서블릿 요청 URL 패턴	//web.xml에 사용된다.

 */


//이 예제는 배포서술자(Deployment Descriptor, DD->web.xml)를 이용해서 실행할 Servlet예제이다.

package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet클래스는 HttpServlet을 상속해서 작성한다. 
public class ServletTest01 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//이곳에는 대부분 service()메서드 또는 doGet()메서드나 doPost()메서드를 재정의해서 작성한다.
	//doGet()메서드나 doPost()메서드는 service()메서드에서 전송방식(GET,POST)에 따라 자동으로 호출된다.
	//HttpServletRequest객체 		=> 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	//HttpServletResoponse객체 	=> 서비스 응답에 과련된 정보 및 메서드를 관리하는 객체
	
	@Override //doGet작성후 ctrl+space 누르면 아래와 같이 자동생성됨. (doPost도 마찬가지로 수행하면 된다.)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8"); //응답문서의 인코딩 방식.(응답을 받아오는거니까 response사용)
		response.setContentType("text/html; charset=utf-8"); //응답문서를 어떤 형식으로 보낼건지를 선택 및 인코딩방식 같이 설정(html로 보낼꺼면 text/html이라고 작성하면 된다.)
	
		//처리한 내용을 응답으로 보내기위한 스트림 객체(PrintWriter객체)를 생성
		PrintWriter out = response.getWriter();	//response는 응답하고 관련되니까 응답할곳에 출력할곳을 write해라.
		
		//처리내용을 출력
		//방법 1) append()메소드 사용
		//방법 2) print()메서드 또는 println()메서드 이용하기 =>ServletTest02.java파일 참고
		
		//방법 1 사용 => append()메소드 사용
		out.append("<!DOCTYPE html>")
		.append("<html>")
		.append("<head>")
		.append("<meta charset='utf-8'>")
		.append("</head>")
		.append("<body>")
		.append("<h2 style = 'text-align : center;'>")
		.append("안녕하세요, 첫번재 서블릿 프로그램입니다.<br>")
		.append("ContextPath : "+request.getContextPath())
		.append("</h2>")
		.append("</body>")
		.append("</html>");
	}
	
}
