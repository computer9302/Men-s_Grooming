package auth;

import lombok.Data;


@Data //lombok 라이브러리를 추가했는데 Data 어노테이션이 적용이 안된다.
public class Auth {
	
		private String username;
		private String auth;
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getAuth() {
			return auth;
		}
		public void setAuth(String auth) {
			this.auth = auth;
		}
		
}
