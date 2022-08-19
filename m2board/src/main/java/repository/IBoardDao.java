package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.Board;

public interface IBoardDao {
	// 자바는 sql과 관련된 모든 인터페이스를 갖고있댕
	// 커넥션으로 받을 수 있댕(자바가 인터페이스를 만들어준댕)
	
	List<Board> selectBoardOne(Connection conn, int boardNo) throws Exception;
	
	List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception;

	
	
	
	int insertnice(Connection conn, Board board);
	
	int insertBoard(Connection conn, Board board) throws SQLException;	

	int selectBoardCnt(Connection conn, int rowPerPage) throws SQLException;
	
}
