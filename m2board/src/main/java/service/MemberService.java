package service;

import java.sql.Connection;
import java.sql.SQLException;

import command.DBUtil;
import repository.MemberDao;
import vo.Member;

public class MemberService {
	
	
	// 회원정보 수정하기
	public int modifyMember(Member parammember) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			// 리턴값에 넣어줄 객체 생성
			MemberDao memberDao = new MemberDao();
			result= memberDao.updateMember(conn, parammember);
			
			System.out.println(result +"<-modifyMember의 result");
			
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	
	// 회원가입
	public int addMember(Member parammember) {
		int result =0;
		Connection conn = null;
		
		try {
			conn = new DBUtil().getConnection(); // DB연동
			conn.setAutoCommit(false); // 자동커밋 방지
			
			
			// 리턴값에 넣어줄 객체 생성
			MemberDao memberDao = new MemberDao();
			result = memberDao.insertMember(conn, parammember);
			
			// 디버깅
			System.out.println(result+"<-addMember의");
			conn.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(result+"<-addBoard의 result");
		return result;
		
	}
	
	
	// 로그인
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
