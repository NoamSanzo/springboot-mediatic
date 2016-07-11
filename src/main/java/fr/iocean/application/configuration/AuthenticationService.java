package fr.iocean.application.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.iocean.application.authorization.Authorization;
import fr.iocean.application.user.User;
import fr.iocean.application.user.repository.UserRepository;

@Component
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		User user = userRepository.findByLogin(username);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), this.getAuthorities(user));
		}
		throw new UsernameNotFoundException("username.not.found");
	}
	
	public List<GrantedAuthority> getAuthorities(User user) {
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Authorization a : user.getAuthorizations()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(a.getCode()));
		}
		return grantedAuthorities;
		
//		return user.getAuthorities().stream().map(a -> new SimpleGrantedAuthority(a.getCode())).collect(Collectors.toList());
		
	}
		
	

}
