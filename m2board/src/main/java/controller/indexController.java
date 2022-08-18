package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index")
public class indexController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession();
		 * 
		 * if(session.getAttribute("loginMember") != null ) {// 로그인된 상태
		 * response.sendRedirect(request.getContextPath() +"/index"); return; }
		 */
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		// 리퀘스트객체 생성 & 포워드는 내 안이라서 컨텍트명이 필요가 없대
		rd.forward(request, response);
	
	
	
	
	}



}
