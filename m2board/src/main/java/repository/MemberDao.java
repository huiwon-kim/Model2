package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao {

	
	// 회원가입시
	public int insertMember(Connection conn, Member parammember) {
		
		/*
		  
		  */
		
		
	}
	
	
	
	// 로그인시
	public Member selectMemberLogin(Connection conn, Member parammember) throws SQLException {
		Member loginmember = new Member();
		
		/*
		SELECT 
		member_id,
		member_pass,
		member_name,
		create_date
		FORM member
		WHERE member_id =? AND member_pass=PASSWORD(?)
		
		*/
		
		String sql ="	SELECT"
				+ "		member_id,"
				+ "		member_pass,"
				+ "		member_name,"
				+ "		create_date"
				+ "		FROM member"
				+ "		WHERE member_id =? AND member_pass=PASSWORD(?)";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, parammember.getMemberId());
			stmt.setString(2, parammember.getMemberPass());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				loginmember = new Member();
				loginmember.setMemberId(rs.getString("member_id"));
				loginmember.setMemberPass(rs.getString("member_pass"));
				loginmember.setMemberName(rs.getString("member_name"));
				
			}
			
			
		} finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
		}
		
		
		
		return loginmember;
	}
}
