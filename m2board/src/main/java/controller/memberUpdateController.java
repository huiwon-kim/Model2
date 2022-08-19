package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/memberUpdate")
public class memberUpdateController extends HttpServlet {

	// 업데이트 폼 보여주는
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null ) {// 로그인 ㄴㄴ면
			response.sendRedirect(request.getContextPath() +"/index"); // 그 서블릿 실행시킬때는 이렇게
			return;
		}
		
		// 아니면 수정폼으로 보낼거양
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/memberUpdate.jsp");
		// 리퀘스트객체 생성 & 포워드는 내 안이라서 컨텍트명이 필요가 없대
		rd.forward(request, response);
	}

	
	// 업데이트 액션 처리하는 (수정폼에서 수정사항 받는 부분)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null ) {// 로그인 ㄴㄴ면
			response.sendRedirect(request.getContextPath() +"/index"); // 그 서블릿 실행시킬때는 이렇게
			return;
		}
		
		
		
		String memberId = request.getParameter("memberId");
		String memmberPass = request.getParameter("memberPass");
		String memberName = request.getParameter("memberName");
		String memberGender = request.getParameter("memberGender");
		String memberAddr = request.getParameter("addr");
		String memberdetailAddr = request.getParameter("detailAddr");
		String createDate = request.getParameter("createDate");
		
		
		
		
		
		
		
	}

}
