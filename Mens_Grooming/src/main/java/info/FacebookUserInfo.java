package info;

import java.util.Map;

import lombok.Data;

@Data	// getter, setter 생성 안해도 먹혀야하는데 안되는거 같음. 확인할것.
public class FacebookUserInfo implements OAuth2UserInfo{
	private Map<String, Object> attributes;

	public FacebookUserInfo(Map<String, Object> attributes) {
		super();
		this.attributes = attributes;
	}

	@Override
	public String getProviderId() {
		// TODO Auto-generated method stub
		return (String)attributes.get("id");
	}

	@Override
	public String getProvider() {
		// TODO Auto-generated method stub
		return "facebook";
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
