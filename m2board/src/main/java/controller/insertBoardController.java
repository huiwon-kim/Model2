package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.BoardDao;
import service.BoardService;
import vo.Board;

/**
 * Servlet implementation class insertBoardController
 */
@WebServlet("/insertBoard")
public class insertBoardController extends HttpServlet {

	
	// 그냥 겟은 입력폼 있으면 겟으로 쓰래
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addBoard.jsp");
		// 리퀘스트객체 생성 & 포워드는 내 안이라서 컨텍트명이 필요가 없대
		rd.forward(request, response);
	}

	
	// 그 입력폼에서 액션 쏘면 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String boardTitle =request.getParameter("boardTitle");
		String boardPw = request.getParameter("boardPw");
		String boardText = request.getParameter("boardText");
		
		int row=0;
		
		Board board = new Board();
		BoardService boardService= new BoardService();
		
		board.setMemberId(memberId);
		board.setBoardTitle(boardTitle);
		board.setBoardPw(boardPw);
		board.setBoardText(boardText);
		
		System.out.println(board.toString());
		
		row = boardService.addBoard(board); // board의
		
		if(row == 0) {
			System.out.println("입력실패");
			response.sendRedirect(request.getContextPath() +"/boardList");
		} else {
			System.out.println("입력성공");
			response.sendRedirect(request.getContextPath() +"/boardList");
		}
		
	}

}
