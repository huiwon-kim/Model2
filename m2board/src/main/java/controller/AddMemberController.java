package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.MemberDao;
import service.MemberService;
import vo.Member;


@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	
	// 회원가입 폼에서 넘어오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/addMember.jsp").forward(request, response);
	}

	
	
	// 회원가입 액션처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 폼에서 넘어온 변수 받아주기		
		String memberId = request.getParameter("memberId");
		String memberPass = request.getParameter("memberPass");
		String memberName = request.getParameter("memberName");
		String memberGender = request.getParameter("memberGender");
		String memberAdd = request.getParameter("addr");
		String memberdetailAdd = request.getParameter("detailAddr");
		
		
		// 집어넣을 멤버객체와 메서드 빌려올 서비스객체 만듦
		Member member = new Member();
		MemberService memberService = new MemberService();
		
		
		// 리턴할 변수 생성 (디버깅 확인용)
		int row = 0;
		
		// 앞에서 선언한 객체 member에 폼에서 넘어온 변수 저장
		member.setMemberId(memberId);
		member.setMemberPass(memberPass);
		member.setMemberName(memberName);
		member.setMemberGender(memberGender);
		member.setMemberAdd(memberAdd);
		member.setMemberdetailAdd(memberdetailAdd);
		
		// 디버깅 - 멤버vo에 toString 추가
		System.out.println(member.toString());
		
		// int로 리턴할 변수 row에 memberServie의 어떤 메서드를 실행시키고 member를 넣어줄거야
		row = memberService.addMember(member);
				
		// 
		if(row == 0) {
			System.out.println("가입실패");
			//response.sendRedirect(request.getContextPath() +"/login");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		} else {
			System.out.println("가입성공");
			//response.sendRedirect(request.getContextPath() +"/login");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
		
		
	}
	

}
