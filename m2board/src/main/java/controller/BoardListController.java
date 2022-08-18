package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;


@WebServlet("/boardList") //★
public class BoardListController extends HttpServlet {
    // ┌ 그냥 정보은닉하려는거니까... public만 아니면 되는듯?
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 컨트롤러의 역할
		// 1. 요청 분석 (요청을받아들여서 분석)
		final int ROW_PER_PAGE = 10;
		
		
		
		int currentPage = 1;
		if(request.getParameter("currentPage") !=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		// 2. 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		// new
		boardService = new BoardService();
		Map<String, Object> map = boardService.getBoardList(ROW_PER_PAGE, currentPage);
		request.setAttribute("lastPage", map.get("lastPage"));
		//						└라스트 페이지 보낼건데 값은 ┘ 여기에 있어
		
		request.setAttribute("list", map.get("list"));
		//						└리스트 보낼건데 값은 ┘ 여기에 있어
		
		request.setAttribute("currentPage", currentPage);
		
		// 3. 뷰 포워딩 (뷰가 있다면)								★ , ★ 2개(15행 45행)는 이름 통일하는거 선생님이 좋아하신대
		request.getRequestDispatcher("/WEB-INF/view/boardList.");
	
	}

}
