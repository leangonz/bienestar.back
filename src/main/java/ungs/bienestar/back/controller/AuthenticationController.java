package ungs.bienestar.back.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungs.bienestar.back.dto.UsuarioDto;

@RestController
public class AuthenticationController {

	@CrossOrigin(origins = "*")
	@RequestMapping("/usuario")
    public UsuarioDto usuario(Authentication authentication) {
        return userDetailsToUsuarioDto(authentication.getName(), authentication.getAuthorities());
    }

	private UsuarioDto userDetailsToUsuarioDto(String username, Collection<? extends GrantedAuthority> authorities) {
		UsuarioDto dto = new UsuarioDto();
		dto.setUsername(username);
		dto.setAuthorities(new ArrayList<>());
		authorities.forEach(x -> dto.getAuthorities().add(x.getAuthority()));
		return dto;
	}
}
