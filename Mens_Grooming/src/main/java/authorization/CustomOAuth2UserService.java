package authorization;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import biz.MemberBiz;
import common.CustomException;
import dto.Member;
import exception.ErrorCode;
import lombok.Delegate;

@Component
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{

	private final MemberBiz biz = null;
	private final DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		String email = (String)oAuth2User.getAttributes().get("email");
		
		if(email == null) {
			throw new CustomException(ErrorCode.NOT_FOUND_USER);
		}
		
		Member member = biz.read(email);
		if(member == null) {
			throw new CustomException(ErrorCode.NOT_FOUND_USER);
		}
	
		return new PrincipalDetail(member);
	}
}
