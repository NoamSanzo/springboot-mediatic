package fr.iocean.application.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.application.user.User;
import fr.iocean.application.user.service.UserService;

@RestController
@RequestMapping("/api/user")
@Transactional
public class UserController {

	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/connexion.login",method = RequestMethod.POST)
	public void connexionLogin(){
		System.out.println("inside connexionLogin()");
	}
	
}
