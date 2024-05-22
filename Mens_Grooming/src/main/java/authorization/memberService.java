package authorization;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import biz.MemberBiz;
import dto.Member;
import dto.SignUpDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class memberService implements UserDetailsService{
	
	private final MemberBiz memberRepository = null;
	
	public void saveMember(SignUpDto signUpDto) {
		
		validateDuplicateMember(signUpDto);
		memberRepository.register(signUpDto);
	}
	
	private void validateDuplicateMember(SignUpDto signUpDto) {
		Optional<Member> byEmailOptional = Optional.ofNullable(memberRepository.findByEmail(signUpDto.getEmail()));
		if(byEmailOptional.isPresent()) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}