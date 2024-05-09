package authorization;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

// PrincipalDetails
public interface UserDetails extends Serializable{

	String getUsername();	// 사용자명 반환
	String getPassword();		// 등록된 패스워드 반환(패스워드 틀리면 BadCredentialException 발생)
	boolean isEnabled();	// 유효한 패스워드인지 판단
	boolean isAccountNonLocked();	// 계정의 잠금 상태를 판단
	boolean isAccountNonExpired();	// 계정의 유효 기간 상태를 판단
	boolean isCredentialsNonExpired();	//	자격정보의 유효 기간 상태를 판단
	Collection<? extends GrantedAuthority> getAuthorities();	// 사용자가 가진 권한 리스트 반환(인가 처리를 할 때 필요)
}
