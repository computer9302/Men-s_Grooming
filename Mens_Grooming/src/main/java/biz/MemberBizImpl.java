package biz;

import java.util.Optional;

import org.h2.api.ErrorCode;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.approval.InMemoryApprovalStore;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import auth.Auth;
import auth.AuthType;
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
	private final MemberBiz biz;
	private final PasswordEncoder passwordEncoder=null;
	private final AuthenticationManager authenticationManager=null;

	@Override
	public int join(MemberDto dto) {
		return dao.join(dto);
	}
	
	@Override
	public int register(Member member) {
		
		member.setName(member.getName());
		member.setEmail(member.getEmail());
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		member.setRole(AuthType.ROLE_USER);
		
		Auth auth = null;
		auth.setUsername(member.getName());
		auth.setAuth("ROLE_USER");
		
		// 왜 있는지 모르겠음. 나중에 필요하다고 판단되면 구현할것.
		// auth 테이블을 참조해서 oauth_user_details의 auth 외래키에 값을 저장해야함.
		biz.insertAuth(auth);
		
		member.addMemberRole(auth);
		
		return dao.register(member);
	}
	
	public void insertAuth(Auth auth) {
		dao.insertAuth(auth);
	}
	
	@Override
	public Optional<Member> findByEmail(String email){
		return dao.findByEmail(email);
	}
	
	public Member login(LoginDto loginDto) {
		
		org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return dao.login(loginDto);
	}


	@Override
	public Member read(String email) {
		// TODO Auto-generated method stub
		return dao.read(email);
	}

	@Override
	public org.springframework.security.core.userdetails.User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}
}
