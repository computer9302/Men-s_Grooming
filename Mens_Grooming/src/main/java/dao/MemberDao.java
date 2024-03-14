package dao;

import dto.MemberDto;

public interface MemberDao {
	String NAMESPACE = "mymember.";
	
	//회원가입
	public int join(MemberDto dto);
}
