package authorization;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import dto.Member;
import lombok.Getter;

@Getter
public class PrincipalDetail extends User{

	private Member member;
	
	public PrincipalDetail(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		
		super(username, password, authorities);
	}
	
	public PrincipalDetail(Member vo) {
		// 코드를 이해 못했음.
		super(vo.getEmail(), vo.getPassword(), vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
	
		this.member = vo;
	}
}
