package authorization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import auth.Auth;
import auth.AuthType;
import dto.Member;
import lombok.Getter;
import java.util.stream.*;

@Getter
public class PrincipalDetail implements OAuth2User, UserDetails{

	private Member member;
	private Map<String, Object> attributes;
	
	// 기존 생성자
	public PrincipalDetail(Member member) {
	        this.member = member;
	    }
	
	// OAuth2User 생성자
	public PrincipalDetail(Member member, Map<String, Object> attributes) {
		this.member = member;
		this.attributes = attributes;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return member.getEmail();
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return attributes;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return member.getEmail();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return member.getPassword();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Auth auth : member.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuth()));
		}
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}



}
