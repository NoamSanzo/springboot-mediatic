package fr.iocean.application.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.iocean.application.user.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u fetch u.authorizations where u.login = :login")
	User findByLogin(@Param("login") String login);
	
}
