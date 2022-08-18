package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import command.DBUtil;
import repository.BoardDao;

public class BoardService implements IBoardService {

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
			map.put("list" ,boardDao.selectBoardListByPage(conn, rowPerPage, beginRow));
			
			
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
