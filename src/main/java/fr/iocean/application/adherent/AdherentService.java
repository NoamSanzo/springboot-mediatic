package fr.iocean.application.adherent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdherentService {

	@Autowired
	private AdherentRepository adherentRepo;
	
	public void create(Adherent adherent){
		adherentRepo.save(adherent);
	}
	public Adherent findById(Long id){
		return adherentRepo.findOne(id);
	}
	public Adherent update(Adherent adherent){
		return adherentRepo.save(adherent);
		
	}
	public List<Adherent> findAll() {
		return adherentRepo.findAll();
	}
	
	public AdherentRepository getAdherentRepo() {
		return adherentRepo;
	}
	public void setAdherentRepo(AdherentRepository adherentRepo) {
		this.adherentRepo = adherentRepo;
	}
	
}
