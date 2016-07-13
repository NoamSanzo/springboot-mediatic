package fr.iocean.application.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

	@Autowired
	MediaRepository mediaRepo;

	public void create(Media u) {
		mediaRepo.save(u);
	}

	public Media findOne(Long id) {
		return mediaRepo.findOne(id);
	}

	public List<Media> findAll() {
		return mediaRepo.findAll();
	}

	public Media update(Media resource) {
		if (mediaRepo.findOne(resource.getId()) != null) {
			return mediaRepo.save(resource);
		}
		return null;
	}
	
	List<Media> search(String titre, String type, String auteur){
		return mediaRepo.search(titre, type, auteur);
	}
}
