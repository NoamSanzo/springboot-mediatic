package fr.iocean.application.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.iocean.application.user.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByLogin(String login);
	
}
