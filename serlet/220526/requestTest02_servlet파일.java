//저장된 위치 : webTest/java Resources / src /  kr.or.ddit.basic.reqNresp / requestTest02.java파일

package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class requestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int number1 = Integer.parseInt(request.getParameter("num1"));
		String op = request.getParameter("op");

		response.setCharacterEncoding("utf-8");
		
		//응답으로 가는 데이터는 어떤 데이터..?
		response.setContentType("text/html; charset=utf-8");
		//출력할 스트림 객체 구하기
		PrintWriter out = response.getWriter();
		
		int number2 = Integer.parseInt(request.getParameter("num2"));
		
		double res = 0;
		boolean calcOk = true;	//계산 성공 여부가 저장될 변수(계산 성공 : true / 계산 실패 : false)
		switch(op) {
		case "+" : res = number1 + number2; break;
		case "-" : res = number1 - number2; break;
		case "*" : res = number1 * number2; break;
		case "/" : 
					if(number2!=0) {
						res = number1 / (double)number2; 
					}else {
						calcOk = false;
					} break;
		case "%" :
					if(number2!=0) {
						 res = number1 % number2; break;	
					}else {
						calcOk = false;
					} break;
		
		}
		out.println(number1 + op + number2 + " = ");
		if(calcOk==true) {
			out.println(res);
		}else{
			out.println("게산 불가");
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
