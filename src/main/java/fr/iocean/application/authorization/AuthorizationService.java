package fr.iocean.application.authorization;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

	@Autowired
	AuthorizationRepository authorRepo;
	
	public void create(Authorization aut){
		authorRepo.save(aut);
	}
	
	public Authorization update(Authorization resource){
		if (authorRepo.findOne(resource.getId()) != null) {
			return authorRepo.save(resource);
		}
		return null;
	}
}
