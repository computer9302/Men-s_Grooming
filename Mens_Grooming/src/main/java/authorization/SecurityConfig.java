package authorization;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import biz.PrincipalDetailsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

		private final memberService memberService = null;
	
		private final PrincipalDetailsService principalDetailsService;
		private final UserDetailsService userDetailsService;
		private final CustomOAuth2UserService customOAuth2UserService;
		
		@Autowired
		public SecurityConfig(UserDetailsService userDetailsService, PrincipalDetailsService principalDetailsService, CustomOAuth2UserService customOAuth2UserService) {
			super();
			this.userDetailsService = userDetailsService;
			this.principalDetailsService = principalDetailsService;
			this.customOAuth2UserService = customOAuth2UserService;
		}



		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		

		
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http.csrf().disable();
			http.formLogin()
				.loginPage("/member/login")
				.defaultSuccessUrl("/")
				.usernameParameter("email")
				.failureUrl("/member/login/error")
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
				.logoutSuccessUrl("/");
			
			http.oauth2Login()
					.userInfoEndpoint()
					.userService(customOAuth2UserService);
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(memberService)
					.passwordEncoder(passwordEncoder());
		}
		
		@Bean
		public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
			return configuration.getAuthenticationManager();
		}
}
