package dto;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource.AuthenticationType;

import org.springframework.security.core.GrantedAuthority;

import auth.Auth;
import auth.AuthType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
public class Member {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private Timestamp createdAt;
	
	private AuthType role;
	
	//id 한개에 권한이 여러개일 이유가 없는데 왜 arrayList인가?
	private List<Auth> authList = new ArrayList<Auth>();

	public Member(Long id, String name, String email, String password, Timestamp createdAt, AuthType role,
			List<Auth> authList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.role = role;
		this.authList = authList;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public AuthType getRole() {
		return role;
	}

	public void setRole(AuthType role) {
		this.role = role;
	}

	public List<Auth> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Auth> authList) {
		this.authList = authList;
	}
	
	public void addMemberRole(Auth auth) {
		authList.add(auth);
	}


	
}
