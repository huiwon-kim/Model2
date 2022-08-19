package vo;

public class Member {
	private String memberId;
	private String memberPass;
	private String memberName;
	private String memberGender;
	private String memberAdd;
	private String memberdetailAdd;
	private String createDate;
	
	
	
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPass=" + memberPass + ", memberName=" + memberName
				+ ", memberGender=" + memberGender + ", memberAdd=" + memberAdd + ", memberdetailAdd=" + memberdetailAdd
				+ ", createDate=" + createDate + "]";
	}
	public String getMemberAdd() {
		return memberAdd;
	}
	public void setMemberAdd(String memberAdd) {
		this.memberAdd = memberAdd;
	}
	public String getMemberdetailAdd() {
		return memberdetailAdd;
	}
	public void setMemberdetailAdd(String memberdetailAdd) {
		this.memberdetailAdd = memberdetailAdd;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
