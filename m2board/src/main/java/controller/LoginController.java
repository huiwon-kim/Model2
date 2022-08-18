package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IMemberService;
import vo.Member;


@WebServlet("/loginController")
public class LoginController extends HttpServlet { // 서블릿이라 내장객체를 슬 수 없음(만들어진 변수말고는 쓸 수없대)	
	private IMemberService memberService;
	
	
	// login form							변수1								변수2
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null ) {// 로그인된 상태
			response.sendRedirect(request.getContextPath() +"/index");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		// 리퀘스트객체 생성 & 포워드는 내 안이라서 컨텍트명이 필요가 없대
	
	}


	// login action 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null ) {// 로그인된 상태
			response.sendRedirect(request.getContextPath() +"/index");
			return;
		}
		
		// 뭔 디비가 분리되어야한대 ㅎ;
		// 보드에 좋아요 내장시 무한좋아요가능함 >> 안됨
		// 좋아요 테이블이 분리되어야한대 그래야 좋아요가 한번만 눌린대
		
		
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			Member paramMember = new Member();
			
			// new 해주고
			Member member = memberService.getMemberLogin(paramMember);
			//		└리턴타입
			if(member==null) {
				// 로긴실패
				System.out.println("로그인실패");
				response.sendRedirect(request.getContextPath() +"/loginController");
				return; // 메서드가 끝나기위해 필요한 리터눔ㄴ. 겟넘버바이로긴을 호출햇는데도
				
			} 
			
				// 로긴성공 >>> 세션에 집어넣기 >>> 근데 서블릿에는 세션이 없엉 
				// 매개변수로 세션을 받아야하는데 리퀘스트에는 세션을 참조할 수잇엉
				// 세션이 생기면 세션안에 리퀘스트가 생기는거거			
			HttpSession session = request.getSession(); // 이러면 ㅅ션 꺼낸거래
			session.setAttribute("loginMember", member);
			response.sendRedirect(request.getContextPath() +"/index");
			
			
	}

}
