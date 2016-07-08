package fr.iocean.application.authorization;

import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iocean.application.*;

@Repository
public interface AuthorizationRepository  extends JpaRepository<Authorization, Long>{

}
