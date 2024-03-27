package dao;

import org.springframework.stereotype.Repository;

import dto.MemberDto;

@Repository
public interface MemberDao {
	String NAMESPACE = "mymember.";
	
	//회원가입
	public int join(MemberDto dto);
}
