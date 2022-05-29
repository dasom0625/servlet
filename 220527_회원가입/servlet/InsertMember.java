package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/InsertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//요청시 전송데이터를 vo에 저장하기
		String userId = request.getParameter("mem_id");
		String userName = request.getParameter("mem_name");
		String userPass = request.getParameter("mem_pass");
		String userHp = request.getParameter("mem_hp");
		String userMail = request.getParameter("mem_mail");
		String userBir = request.getParameter("mem_bir");
		String userZip = request.getParameter("mem_zip");
		String userAdd1 = request.getParameter("mem_add1");
		String userAdd2 = request.getParameter("mem_add2");
		
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(userId);
		vo.setMem_name(userName);
		vo.setMem_pass(userPass);
		vo.setMem_hp(userHp);
		vo.setMem_mail(userMail);
		vo.setMem_bir(userBir);
		vo.setMem_zip(userZip);
		vo.setMem_add1(userAdd1);
		vo.setMem_add2(userAdd2);
		
		//service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		//service메소드 호출하기
		String id = service.insertMember(vo);
		
		//결과값을 공유할 수 있도록 request에 저장한다.
		request.setAttribute("servletUserId", id);//userId의 value가 id
		
		//View페이지로 이동=>redirect혹은 forward사용
		request.getRequestDispatcher("0525/insert.jsp").forward(request, response);
		
		
	}
}
