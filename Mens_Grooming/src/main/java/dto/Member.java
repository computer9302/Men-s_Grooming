package dto;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource.AuthenticationType;

import auth.AuthType;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Member {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private Timestamp createdAt;
	
	private AuthType role;
	
	private List<AuthVO> authList = new ArrayList<>();

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

	public List<AuthVO> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}
	
	
}