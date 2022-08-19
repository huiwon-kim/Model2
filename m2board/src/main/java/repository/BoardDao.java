package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.Board;
import vo.Nice;

public class BoardDao implements IBoardDao {

	// 게시글 상세보기
	public List<Board> selectBoardOne(Connection conn, int boardNo) throws Exception {
		
		/*
		 SELECT
		 board_no boardNo,
		 member_id memberId,
		 board_title boardTitle,
		 board_text boardText,
		 board_nice boardNice,
		 board_vice boardView,
		 create_date createDate
		 FROM board
		 WHERE boardNo=?
		 */
		
		String sql ="		 SELECT\r\n"
				+ "		 board_no,\r\n"
				+ "		 member_id,\r\n"
				+ "		 board_title,\r\n"
				+ "		 board_text,\r\n"
				+ "		 board_nice,\r\n"
				+ "		 board_view,\r\n"
				+ "		 create_date\r\n"
				+ "		 FROM board\r\n"
				+ "		 WHERE board_no=?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Board board = new Board();
		List<Board> list = null;
		
		try {
			list = new ArrayList<Board>();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardNo);
			rs= stmt.executeQuery();
			
			
			while(rs.next()) {
				board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setMemberId(rs.getString("member_id"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardText(rs.getString("board_text"));
				board.setBoardNice(rs.getInt("board_nice"));
				board.setBoardView(rs.getInt("board_view"));
				board.setCreateDate(rs.getString("create_date"));
				list.add(board);
				
				System.out.println(list+"<-boardOne의 list");
			}
			
			
		} finally {
			if (rs!=null) {rs.close();}
			if (stmt!=null) {stmt.close();}
		}
		
		return list;
	}
	
	
	// 좋아요를 보여주는?
	public int viewnice(Connection conn, Board board) {
		
		/*
		SELECT b.board_no, b.board_title, t.cnt
		FROM board b
		INNER JOIN
		(SELECT board_no, COUNT(*) cnt
		FROM nice
		GROUP BY board_no) t
		ON b.board_no = t.board_no		 
		  
		 */
		int result = 0;
		
		String sql ="SELECT b.board_no, b.board_title, t.cnt\r\n"
				+ "FROM board b\r\n"
				+ "INNER JOIN\r\n"
				+ "(SELECT board_no, COUNT(*) cnt\r\n"
				+ "FROM nice\r\n"
				+ "GROUP BY board_no) t\r\n"
				+ "ON b.board_no = t.board_no		";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			stmt = conn.prepareStatement(sql);
			
			
			
		} finally {
			
			
		}
		
		
		
		
		return result;
		
	}
	
	
	// 좋아요 업데이트
	public int insertNice(Connection conn, Board board, Nice nice) {
		int row = 0;
		
		/*
		 UPDATE board 
		 SET
		 board_nice=board_nice+1 
		 WHERE board_no=?		  
		  */
		
		String sql = "	UPDATE board"
				+ "		 SET"
				+ "		 board_nice=board_nice+1"
				+ "		 WHERE board_no=?	";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, board.getBoardNo());			
			row = stmt.executeUpdate();
			
			System.out.println(row +"<-insertNice의 row");
		} finally {
			
		}
		
	
	}
	
	
	
	// 게시글입력
	@Override
	public int insertBoard(Connection conn, Board board) throws SQLException {
		int row = 0;
		
		
		/*
		 INSERT INTO board
		  (member_id, board_title, board_text,
		  board_nice, board_view, create_date )
		  VALUES (?, ?, ?, ?, ?, now() )
		  
		  
		 */
		
		String sql ="INSERT INTO board (member_id, board_pw, board_title, board_text, create_date)"
				+ " VALUES (?, ?, ?, ?, NOW())";
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, board.getMemberId());
			stmt.setString(2, board.getBoardPw());
			stmt.setString(3, board.getBoardTitle());
			stmt.setString(4, board.getBoardText());
			row = stmt.executeUpdate();
			
			if(row==0) {
				  System.out.println(row+"<-입력실패");
			}
			
		} finally {
			if(stmt!=null) {stmt.close();}
		}
		
		
		return row;
	}
	
	// 리스트보기
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
				+ "		 member_id memberId,\r\n"
				+ "		 board_title boardTitle,\r\n"
				+ "		 board_text boardText,\r\n"
				+ "		 board_nice boardNice,\r\n"
				+ "		 board_view boardView,\r\n"
				+ "		 create_date createDate\r\n"
				+ "		 FROM board\r\n"
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
			System.out.println(rs+"<-selectBoardListByPage의 rs");
			
			while(rs.next()) {
				board = new Board();
				board.setBoardNo(rs.getInt("boardNo"));
				board.setMemberId(rs.getString("memberId"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardNice(rs.getInt("boardNice"));
				board.setBoardView(rs.getInt("boardView"));
				board.setCreateDate(rs.getString("createDate"));
				list.add(board);
			}
			System.out.println(list+"<-selectBoardListByPage의 list");
			
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
	public int selectBoardCnt(Connection conn, int rowPerPage) throws SQLException {
		
		
		/*
		SELECT COUNT(*) FROM m2board;
	
		*/
		String sql = "SELECT COUNT(*) FROM m2board;";
		int totalRow = 0;
		int lastPage = 0;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				totalRow = rs.getInt("COUNT(*)");
			}
		
			lastPage = totalRow / rowPerPage;
			if(totalRow % rowPerPage != 0) {
					lastPage += 1;
				}
			
		} finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
		}	
		
		return lastPage;
	}

}
