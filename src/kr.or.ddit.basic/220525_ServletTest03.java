//220525
package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet의 LifeCycle예제
@WebServlet("/servletTest03.do")
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet : "+this.getServletName() + "에서 init()메서드 호출!");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet : "+this.getServletName() + "에서 destroy()메서드 호출!");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()메서드 시작");
		//GET방식과 POST방식에 맞는 메서드 호출하기
		
		//방법 1 ==> HttpServlet(부모클래스)의 service()메서드로 위임하기
		super.service(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메서드 시작");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'></head><body><h2>doGet()메서드 처리 결과입니다.</h2></body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메서드 시작");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'></head><body><h2>doPost()메서드 처리 결과입니다.</h2></body></html>");
	}

}
