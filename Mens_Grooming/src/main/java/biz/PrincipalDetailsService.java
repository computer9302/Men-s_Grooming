package biz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	
	private final MemberBiz biz;
	
	@Autowired
	public PrincipalDetailsService(MemberBiz biz) {
		super();
		this.biz = biz;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		log.info("message");
		Optional<Member> member = biz.findByEmail(email); //Optional의 정의에 의해서 member의 데이터 타입을 Optional<Member>로 한다.


	}
}
