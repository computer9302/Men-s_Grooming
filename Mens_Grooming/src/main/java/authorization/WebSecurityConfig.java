package authorization;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

		private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);

		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http
			.csrf().disable()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.httpBasic();
			
		makeAuthorizationRequestHeader();
		}
		
		@Bean
		public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
			return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		}
		
		@Bean
		public UserDetailsService userDetailsService() {
			org.springframework.security.crypto.password.PasswordEncoder encoder = passwordEncoder();
			String password = encoder.encode("pass");
			log.debug("PasswordEncoder password : [{}] ", password);
			log.debug("PasswordEncoder password : [{}]", encoder.encode("secret"));
			
			InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
			manager.createUser(User.withUsername("user").password(password).roles("USER").build());
			manager.createUser(User.withUsername("admin").password("{nop}pass").roles("USER", "ADMIN").build());
			
			return manager;
		}
		
		private static void makeAuthorizationRequestHeader() {
			String oauthClientId = "client";
			String oauthClientSecret = "secret";
			
			Encoder encoder = Base64.getEncoder();
			try {
				String toEncodeString = String.format("%s:%s", oauthClientId, oauthClientSecret);
				String authorizationRequestHeader = "Basic " + encoder.encodeToString(toEncodeString.getBytes("UTF-8"));
				log.debug("AutorizationRequestHeader : [{}]", authorizationRequestHeader);
			} catch (UnsupportedEncodingException e) {
				// TODO: handle exception
				log.error(e.getMessage(), e);
			}
		}
}
