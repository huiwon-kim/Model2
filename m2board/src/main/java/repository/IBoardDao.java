package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.Board;

public interface IBoardDao {
	List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception;
	// 자바는 sql과 관련된 모든 인터페이스를 갖고있댕
	// 커넥션으로 받을 수 있댕(자바가 인터페이스를 만들어준댕)
	
	
	List<Map<String, Object>> insertBoard(Connection conn, Board board);
	
	int selectBoardCnt(Connection conn) throws SQLException;
	
}
