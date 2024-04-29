package biz;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dto.Member;
import dto.MemberDto;

@Service
public interface MemberBiz {
	//회원가입
	public int join(MemberDto dto);
	
	// sns 회원가입
	public int register(Member member);
	
	// email 찾기
	public Optional<Member> findByEmail(String email);
	
}
