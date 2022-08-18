package service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import vo.Board;

public interface IBoardService {
	// 반환값; List<Board>, int lastPage >>> 두개 리턴하려면 참조형 ㄱ >>> Map에 담아서 리턴
	
	
	int addBoard(Board paramboard);
	
	public int getBoardCnt(int rowPerPage);
	
	Map<String, Object> getBoardOne(int boardNo);
	
	Map<String, Object> getBoardList(int rowPerPage, int currentPage);
	
	
}
