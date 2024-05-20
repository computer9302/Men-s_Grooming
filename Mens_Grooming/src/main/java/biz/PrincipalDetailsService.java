package biz;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import authorization.PrincipalDetail;
import common.CustomException;
import dto.Member;
import exception.ErrorCode;
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
		
		Member member = biz.findByEmail(email); //Optional의 정의에 의해서 member의 데이터 타입을 Optional<Member>로 한다.
		
		if(member == null) {
			throw new CustomException(ErrorCode.NOT_FOUND_USER);
		}
		return new PrincipalDetail(member);

	}
}
