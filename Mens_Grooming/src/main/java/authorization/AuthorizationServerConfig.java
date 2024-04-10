package authorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
		clients
		.inMemory()
		.withClient("client")
		.secret("{nop}secret")
		.redirectUris("http://localhost:8081/callback")
		.authorizedGrantTypes("authrization_code")
		.scopes("read_profile");
	}
}
