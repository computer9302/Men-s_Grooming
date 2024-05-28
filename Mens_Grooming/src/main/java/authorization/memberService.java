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
	
	public void saveMember(Member member) {
		
		validateDuplicateMember(member);
		memberRepository.register(member);
	}
	
	private void validateDuplicateMember(Member member) {
		Optional<Member> byEmailOptional = memberRepository.findByEmail(member.getEmail());
		if(byEmailOptional.isPresent()) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = memberRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return null;
	}
	
}