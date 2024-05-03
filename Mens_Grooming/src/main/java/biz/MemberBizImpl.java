package biz;

import java.util.Optional;

import org.h2.api.ErrorCode;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.approval.InMemoryApprovalStore;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import dto.LoginDto;
import dto.Member;
import dto.MemberDto;
import dto.RoleType;
import dto.SignUpDto;
import dto.User;
import exception.MemoAPIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberBizImpl implements MemberBiz {
	
	
	private final MemberDao dao;
	private final PasswordEncoder passwordEncoder=null;
	
	@Autowired
	public MemberBizImpl(MemberDao dao) {
		this.dao = dao;
	}


	@Override
	public int join(MemberDto dto) {
		return dao.join(dto);
	}
	
	@Override
	public int register(SignUpDto signUpDto) {
		return dao.register(signUpDto);
	}
	
	@Override
	public Optional<Member> findByEmail(String email){
		return dao.findByEmail(email);
	}
	
	public Member login(LoginDto loginDto) {
		return dao.login(loginDto);
	}
}
