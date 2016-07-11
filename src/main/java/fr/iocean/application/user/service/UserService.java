package fr.iocean.application.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.iocean.application.user.User;
import fr.iocean.application.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}
	
	public User findById(Long id) {
		User user = userRepository.findOne(id);
		return user;
	}
	
	public User findByLogin(String login){
		User user = userRepository.findByLogin(login);
		return user;
	}
	
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	public void update(User u){
		userRepository.save(u);
	}
	
	public void delete(User user){
		userRepository.delete(user);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
}
