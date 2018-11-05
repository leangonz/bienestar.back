package ungs.bienestar.back.dto;

import java.util.List;

public class UsuarioDto {

	private String username;
	
	private List<String> authorities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	
}
