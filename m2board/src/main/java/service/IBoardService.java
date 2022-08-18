package service;

import java.util.Map;

public interface IBoardService {
	// 반환값; List<Board>, int lastPage >>> 두개 리턴하려면 참조형 ㄱ >>> Map에 담아서 리턴
	
	Map<String, Object> getBoardList(int rowPerPage, int currentPage);
	
	
}
