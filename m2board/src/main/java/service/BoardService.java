package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.DBUtil;
import repository.BoardDao;
import vo.Board;

public class BoardService implements IBoardService {

	// 게시글 상세보기
	public Map<String, Object> getBoardOne(int boardNo) {
		// 리턴할 객체생성
		Map<String, Object> map = null;
		
		Connection conn=null;
		
		try {
			conn = new DBUtil().getConnection(); // DB연동
			conn.setAutoCommit(false); // 자동커밋 방지
			
			// 리턴값에 넣어주기 위해 객체생성
			BoardDao boardDao = new BoardDao();
			
			// 객체생성 및 메서도 호출하여 리턴값에
			map = new HashMap<>();
			map.put("list", boardDao.selectBoardOne(conn, boardNo));
			
			// 디버깅
			System.out.print(map +"<-getBoardOne의 list");
			conn.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return map;
		
		
	}
	
	
	// 게시글 작성하기
	
	public int addBoard(Board paramboard) {
		int result = 0;
		
		Connection conn = null;
	
		
		try {
			conn = new DBUtil().getConnection(); // 디비연동
			conn.setAutoCommit(false); // 자동커밋방지
			
			BoardDao boardDao = new BoardDao();
			result =boardDao.insertBoard(conn, paramboard);
			
			System.out.println(result+"<-addBoard의");
			conn.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(result+"<-addBoard의 result");
		return result;
		
	}
	
	
	// 게시글 페이징
	public int getBoardCnt(int rowPerPage) {
		Connection conn = null;
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false); //자동커밋방지
			
			BoardDao boardDao = new BoardDao();
			
			rowPerPage = boardDao.selectBoardCnt(conn, rowPerPage);
			
			if(rowPerPage ==0) {
				throw new Exception();
			}
			
			conn.commit();			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return rowPerPage;
		
		
		
		
	}
	
	
	// 게시글 목록보기
	@Override
	public Map<String, Object> getBoardList(final int rowPerPage, int currentPage) {
		
		Map<String, Object> map = null;
		Connection conn = null;
		int beginRow = 0;
		beginRow = (currentPage -1) *rowPerPage;
		
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			BoardDao boardDao = new BoardDao();
			
			map = new HashMap<>();
			// 이게 아님map = (Map<String, Object>) boardDao.selectBoardListByPage(conn, rowPerPage, beginRow);
			map.put("list" , boardDao.selectBoardListByPage(conn, rowPerPage, beginRow));
			
			
			System.out.print(map +"<-map");
			
		
			conn.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return map;
	}

}
