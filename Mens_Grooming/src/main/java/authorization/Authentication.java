package authorization;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

// 참고 코드에 구현 클래스가 없음. 직접 구현해야함.
public interface Authentication extends Principal, Serializable {

	Collection<? extends GrantedAuthority> getAuthorities(); // Authentication 저장소에 의해 인증된 사용자의 권한 목록
	Object getCredentials(); // 주로 비밀번호
	Object getDetails(); // 사용자 상세정보
	Object getPrincipal(); //주로 ID
	boolean isAuthenticated(); // 인증 여부
	void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException;
}
