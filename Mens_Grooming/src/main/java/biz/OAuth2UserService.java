package biz;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import dto.User;
import info.FacebookUserInfo;
import info.GoogleUserInfo;
import info.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService{
	
	private final MemberBiz biz;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
		
		log.info("userRequest: {}", userRequest);
		 
		ClientRegistration clientRegistration = userRequest.getClientRegistration();
		OAuth2User oAuth2User = super.loadUser(userRequest);
		
		oAuth2User.getAuthorities().forEach((k) -> {
			log.info("k: {}", k);
		});
		
		// oauth 회원가입 강제 등록
		OAuth2UserInfo oAuth2UserInfo = null;
		
		if(clientRegistration.getRegistrationId().equals("google")) {
			log.info("구글 로그인 요청");
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAuthorities());
			log.info("oAuth2UserInfo: {}", oAuth2UserInfo);
		}else if(clientRegistration.getRegistrationId().equals("facebook")) {
			log.info("페이스북 로그인 요청");
			oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAuthorities());
		}else {
			log.info("우리는 구글과 페이스북만 지원합니다.");
		}
		
		String email = oAuth2UserInfo.getEmail();
		String name = oAuth2UserInfo.getName();
		log.info("email: {}", email);
		log.info("name: {}", name);
		Optional<User> optionalUser = biz.findByEmail(email);
		
		User user = null;
		if(optionalUser.isPresent()) {
			log.info("로그인을 이미 했음, 자동회원가입이 되어있다.");
		}else {
			user = User.builder()
					.name(name)
					.email(email)
					// password ecode 처리는 controller에 처리하는게 나을 것 같음.
					.password("githere")
					.build();
		
			biz.register(user);
		}
	return oAuth2User;
	}
	 
	
}
