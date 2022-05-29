package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청시 전송데이터 받기 =>클라이언트가 폼에서 입력한 id를 받는것.
		String userId = request.getParameter("id");
		
		//2. service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();	//new로 생성하는게 아니라 빌려오는것 잊지말기
		
		//3. service메소드 호출하기 => 결과값 받기
		String res = service.selectById(userId);	//id중복값을 결과값으로 내뱉는건 String타입이다.(있는 값이면 그 값이 나오고, 없는 값이면 null이 나온다.)
		
		//4.request객체에 결과값을 저장
		request.setAttribute("idResult", res);//setAttrivute("value가 저장될 key값",value-여기서는 service메소드를 호출해서 결과값받은것);
		
		//5. 받은 결과값을 출력하기=>결과 출력은 여기서 하는게 아니라 View페이지로 이동하여 출력한다. 
		/*View페이지로 이동하는 방법
			1) redirect : 서버바깥으로 나감. (다시 지시하다 라는 뜻) 
			2) forward  : 서버내에서 움직임.
		 */
		request.getRequestDispatcher("0525/idcheck.jsp").forward(request, response);//idResult를 페이지로 보낸다. (getRequestDispatcher("보낼 페이지")
	}

}
