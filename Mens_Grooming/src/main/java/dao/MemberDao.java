package dao;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import auth.Auth;
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
	
	// auth 저장
	public void insertAuth(Auth auth);
	
	//email 찾기
	public Optional<Member> findByEmail(String email);
	
	// login
	public Member login(LoginDto loginDto);

	public Member read(String email);

	public User findByUsername(String username);
	
}
