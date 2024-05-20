package dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import dto.LoginDto;
import dto.Member;
import dto.MemberDto;
import dto.SignUpDto;

@Repository
public interface MemberDao {
	String NAMESPACE = "mymember.";
	
	//회원가입
	public int join(MemberDto dto);
	
	//sns 회원가입
	public int register(Member member);
	
	//email 찾기
	public Member findByEmail(String email);
	
	// login
	public Member login(LoginDto loginDto);
	
}
