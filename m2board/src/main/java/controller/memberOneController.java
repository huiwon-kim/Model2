package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;


@WebServlet("/memberOne")
public class memberOneController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/memberOne.jsp");
		// 리퀘스트객체 생성 & 포워드는 내 안이라서 컨텍트명이 필요가 없대
		rd.forward(request, response);
		
		//response.sendRedirect(request.getContextPath() +"/memberUpdate");
	}
/*
	// 회원정보 상세보기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		

		// 원하는 메서드를 부르기 위해 서비스클래스의 객체 생성
		MemberService memberService = new MemberService();
		
		// 변수를 담을 member 객체 생성
		Member member = new Member();
		
		// 객체에 변수 담기
		member = memberService.MemberOne(member);
		
		
		// 담은 것들을 request에 저장하기
		request.setAttribute("memberId", member.getMemberId());
		request.setAttribute("memberPass", member.getMemberPass());
		request.setAttribute("memberName", member.getMemberName());
		request.setAttribute("memberGender", member.getMemberGender());
		request.setAttribute("memberAdd", member.getMemberAdd());
		request.setAttribute("memberDetailAdd", member.getMemberdetailAdd());
		request.setAttribute("createDate", member.getCreateDate());
		
		
		// 디버깅
		System.out.println(member.toString());
		
		//원하는 주소로 보내기
		response.sendRedirect(request.getContextPath() +"/memberOne");
	}*/

}
