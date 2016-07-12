package fr.iocean.application.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.application.adherent.Adherent;
import fr.iocean.application.user.User;
import fr.iocean.application.user.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
@Transactional
public class UserController {

	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "authorities", method = RequestMethod.GET)
	public List<GrantedAuthority> getAuthorization(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 return (List<GrantedAuthority>) auth.getAuthorities();		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody @Valid User user) {
		userService.create(user);
	}
}
