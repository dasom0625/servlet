//220525

/*
이 예제는 애노테이션(@WebServlet)을 이용하여 Servlet을 설정하여 처리하는 예제이다.
@WebServlet 애노테이션은 Servlet버전 3.0이상에서 사용할 수 있다.

- @WebServlet애노테이션의 속성들 
	1) name 		: 서블릿 이름을 설정한다. ( 기본값 : 빈 문자열 (""))
	2) urlPatterns 	: 서블릿의 URL패턴 목록을 설정한다. ( 기본값 : 빈배열({}))
						예) urlPatterns = "/url1" 또는 urlPatterns={"/url1"} ==> 패턴이 1개일 경우
						예) urlPatterns = {"/url1", "/url2",....} =>패턴이 2개 이상일 경우
	3) value 		: urlPatterns와 동일하다.
	4) description 	: 주석(설명글)을 설정한다.
 */


package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
	urlPatterns = {"/servletTest02.ddit"}, description = "애노테이션을 이용한 서블릿"
)
public class ServletTest02 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//doGet()메서드 => GET방식으로 요청할 때 처리되는 메서드
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8"); //응답문서의 인코딩 방식.(응답을 받아오는거니까 response사용)
		response.setContentType("text/html; charset=utf-8"); //응답문서를 어떤 형식으로 보낼건지를 선택 및 인코딩방식 같이 설정(html로 보낼꺼면 text/html이라고 작성하면 된다.)
	
		//처리한 내용을 응답으로 보내기위한 스트림 객체(PrintWriter객체)를 생성
		PrintWriter out = response.getWriter();	//response는 응답하고 관련되니까 응답할곳에 출력할곳을 write해라.
		
		//처리내용을 출력
				//방법 1) append()메소드 사용=> ServletTest01.java파일 참고
				//방법 2) print()메서드 또는 println()메서드 사용
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<body>");
		out.println("<title>두번째 서블릿</title></head>");
		out.println("멀바요??, ");
		out.println("<h2 style = 'text-align : center; color : blue;'>");
		out.println("안녕하세요, 두번째 서블릿입니다.<br>(@WebServlet 애노테이션을 이용한 서블릿)<br>");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
	
	}
	
	//doPost()메서드 => POST방식으로 요청할때 처리되는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
