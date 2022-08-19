package repository;

import java.sql.Connection;
import java.sql.SQLException;

import vo.Member;

public interface IMemberDao {
	
	// 멤버수정하기
	int updateMember(Connection conn, Member parammember) throws Exception;
	
	// 멤버상세보기 >>> 셀렉멤버로그인으로 해결
	
	int insertMember(Connection conn, Member parammember) throws SQLException;
	
	// 매개값 : id, pw 
	// 반환값 : 세션에 저장될 Member의 정보 일부
	Member selectMemberLogin(Connection conn, Member parammember);
	
}
