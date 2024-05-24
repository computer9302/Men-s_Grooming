package info;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data	// getter, setter 생성 안해도 먹혀야하는데 안되는거 같음. 확인할것.
public class GoogleUserInfo implements OAuth2UserInfo{
	
	private Map<String, Object> attributes;
	
	public GoogleUserInfo(Map<String, Object> attributes) {
		super();
		this.attributes = attributes;
	}

	@Override
	public String getProviderId() {
		// TODO Auto-generated method stub
		return (String)attributes.get("sub");
	}

	@Override
	public String getProvider() {
		// TODO Auto-generated method stub
		return "google";
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return (String)attributes.get("email");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return (String)attributes.get("name");
	}


	
	
}
