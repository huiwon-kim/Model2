package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import vo.Board;

public class BoardDao implements IBoardDao {

	@Override
	public List<Map<String, Object>> insertBoard(Connection conn, Board board) {
		List<Map<String, Object>> list = null;
		
		return null;
	}
	
	
	@Override
	public List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception {
		List<Board> list = null;
		// 여기서 
		
		/*
		 SELECT 
		 board_no boardNo,
		 board_writer boardWriter,
		 board_title boardTitle,
		 board_text boardText,
		 board_nice boardNice,
		 board_view boardView,
		 create_date createDate
		 FROM m2board
		 WHERE board_no=? 
		  
		  */
		
		String sql= "		 SELECT \r\n"
				+ "		 board_no boardNo,\r\n"
				+ "		 board_writer boardWriter,\r\n"
				+ "		 board_title boardTitle,\r\n"
				+ "		 board_text boardText,\r\n"
				+ "		 board_nice boardNice,\r\n"
				+ "		 board_view boardView,\r\n"
				+ "		 create_date createDate\r\n"
				+ "		 FROM m2board\r\n"
				+ "		 ORDER BY boardNo DESC LIMIT ?,? ";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Board board = new Board();
		
		try {
			list = new ArrayList<Board>();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setBoardNo(rs.getInt("boardNo"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardNice(rs.getInt("boardNice"));
				board.setBoardView(rs.getInt("boardView"));
				board.setCreateDate(rs.getString("createDate"));
				list.add(board);
			}
			System.out.println(list+"<-list");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
		
	}
		return list;
	}

	
	@Override
	public int selectBoardCnt(Connection conn) throws SQLException {
		
		
		/*
		SELECT COUNT(*) FROM m2board;
	
		*/
		String sql = "SELECT COUNT(*) FROM m2board;";
		int totalRow = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			
			if(rs.next()) {
				totalRow = rs.getInt("COUNT(*)");
			}
		
		} finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
		}	
		
		return totalRow;
	}

}
