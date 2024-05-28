package biz;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import auth.Auth;
import dto.LoginDto;
import dto.Member;
import dto.MemberDto;
import dto.SignUpDto;

@Service
public interface MemberBiz {
	//회원가입
	public int join(MemberDto dto);
	
	// sns 회원가입
	public int register(Member member);
	
	// auth 저장
	public void insertAuth(Auth auth);
	
	// email 찾기
	public Optional<Member> findByEmail(String email);
	
	// sns 로그인x 이거는 security 라이브러리에 구현되어 있는듯. 얘 사용x
	public Member login(LoginDto loginDto);

	// email로 user load
	public Member read(String email);

	public User findByUsername(String username);

	// 왜 있는지 모르겠음 나중에 필요하다고 판단되면 구현할 것.
	//public void insertAuth(Auth auth);
	
}
