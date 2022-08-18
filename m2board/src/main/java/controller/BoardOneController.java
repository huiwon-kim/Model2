package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;
import vo.Board;


@WebServlet("/boardOne")
public class BoardOneController extends HttpServlet {
	private IBoardService boardService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		boardService = new BoardService();		
		
		Map<String, Object> map = boardService.getBoardOne(boardNo);
		
		// request에 저장하기
		request.setAttribute("list", map.get("list"));
		
		request.setAttribute("boardNo", map.get("board_no"));
		request.setAttribute("memberId", map.get("member_id"));
		request.setAttribute("boardTitle", map.get("board_title"));
		request.setAttribute("boardText", map.get("board_text"));
		request.setAttribute("boardNice", map.get("board_nice"));
		request.setAttribute("boardView", map.get("board_view"));
		request.setAttribute("createDate", map.get("create_date"));
		
		
		request.getRequestDispatcher("/WEB-INF/view/boardOne.jsp").forward(request, response);
		
	}



}
