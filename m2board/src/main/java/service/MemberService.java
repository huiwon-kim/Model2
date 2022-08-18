package service;

import java.sql.Connection;
import java.sql.SQLException;

import command.DBUtil;
import repository.MemberDao;
import vo.Member;

public class MemberService {
	public Member getMemberLogin(Member paramMember) {
		Member parammember = new Member();
		Connection conn = null;
		
		
		try {
			conn = new DBUtil().getConnection();// DB연동
			conn.setAutoCommit(false); // 자동커밋 방지
			
			MemberDao memberDao = new MemberDao();
			parammember = memberDao.selectMemberLogin(conn, paramMember);
			
			conn.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return parammember;
	}
}
