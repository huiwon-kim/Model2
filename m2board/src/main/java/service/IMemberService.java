package service;

import java.sql.Connection;

import vo.Member;

public interface IMemberService {
	// 사실은 아디랑 비번 받아서 여기서 멤버 만드는게 좋대
	// 근데 통상적으로 계층에서 계층으로 정보 넘겨줄때는 묶어서 넘겨주는게 맞대
	// 컨트롤러쪽은 매개값은 vo로 묶어서 보내주는게 좋대
	// 여러개의 매개값으로 넘기려면 vo로 묶어서 해주거나 Map으로 묶어주거나 
	// String  id, pw 말고 묶어서 보내주자 커늩롤러로
	
	
	
	// 회원정보 수정하기
	int modifyMember(Member parammember);
	
	// 회원가입
	int addMember(Member parammember);
	
	// 로그인
	Member getMemberLogin(Member paramMember);
	
}
