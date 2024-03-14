package biz;

import org.springframework.stereotype.Service;

import dto.MemberDto;

@Service
public interface MemberBiz {
	//회원가입
	public int join(MemberDto dto);
}
