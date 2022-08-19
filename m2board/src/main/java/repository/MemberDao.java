package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao {

	
	// 회원정보 수정시
	public int updateMember(Connection conn, Member parammember) throws Exception {
		
		/*
		UPDATE member
		SET
		
		member_pass=PASSWORD('?'),
		member_name='?',
		member_gender='?',
		member_add='?',
		member_detailadd='?'		
		
		WHERE member_id='?'
		*/
		String sql ="		UPDATE member\r\n"
				+ "		SET\r\n"
				+ "		member_pass=PASSWORD('?'),\r\n"
				+ "		member_name=?,\r\n"
				+ "		member_gender=?,\r\n"
				+ "		member_add=?,\r\n"
				+ "		member_detailadd=?		\r\n"
				+ "		WHERE member_id=?";
		
		int row =0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, parammember.getMemberPass());
			stmt.setString(2, parammember.getMemberName());
			stmt.setString(3, parammember.getMemberGender());
			stmt.setString(4, parammember.getMemberAdd());
			stmt.setString(5, parammember.getMemberdetailAdd());
			stmt.setString(5, parammember.getMemberId());
			
			row = stmt.executeUpdate();			
			System.out.print(row+"<-updateMember의 row");
			
		} finally {
			if(rs != null) {rs.close();}
			if(stmt !=null ) {stmt.close();}
		}
		return row;
	}
	
	

	
	// 회원정보 상세보기시 >>> 로그인 메서드를 이용하여 loginmember에 모든 membervo를 저장. 이후 세션에 다 담았기 때문에 따로 상세보기용 메서드를 만들 필요 없음
	
	
	// 회원가입시
	public int insertMember(Connection conn, Member parammember) throws SQLException {
		
		/*
		  INSERT INTO member
		  (member_id, member_pass, member_name,
		  member_gender, member_add, crete_date)
		  VALUES
		  (?, ?, ?, ?, ?, NOW())
		  
		  */
		int row=0;
		String sql="	  INSERT INTO member\r\n"
				+ "		  (member_id, "
				+ "			member_pass, "
				+ "			member_name,"
				+ "		  	member_gender, "
				+ "			member_add, "
				+ "			member_detailadd, "
				+ "			create_date)\r\n"
				+ "		  VALUES\r\n"
				+ "		  (?, PASSWORD(?), ?, ?, ?, ?, NOW());";
	
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, parammember.getMemberId());
			stmt.setString(2, parammember.getMemberPass());
			stmt.setString(3, parammember.getMemberName());
			stmt.setString(4, parammember.getMemberGender());
			stmt.setString(5, parammember.getMemberAdd());
			stmt.setString(6, parammember.getMemberAdd());
			row = stmt.executeUpdate();
			
			if(row ==0) {
				System.out.println("회원정보 입력 실패");
			}
			
		} finally {
		
			if(stmt!=null) {stmt.close();}
		}
		
		return row;
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
				+ "		 member_gender,\r\n"
				+ "		 member_add,\r\n"
				+ "		 member_detailadd,\r\n"
				+ "		 create_date\r\n"
				+ "		 FROM member\r\n"
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
				loginmember.setMemberGender(rs.getString("member_gender"));
				loginmember.setMemberAdd(rs.getString("member_add"));
				loginmember.setMemberdetailAdd(rs.getString("member_detailadd"));
				loginmember.setCreateDate(rs.getString("create_date"));
				System.out.println(loginmember.toString());
			}
			
			
		} finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
		}
		
		
		
		return loginmember;
	}
}
