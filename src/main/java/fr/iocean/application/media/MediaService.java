package fr.iocean.application.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

	@Autowired
	MediaRepository mediaRepo;
	
	public void create(Media u){
		mediaRepo.save(u);
	}
	
	
	public Media findOne(Long id){
		return mediaRepo.findOne(id);
	}
	
	
	public Media update(Media resource){
		if (mediaRepo.findOne(resource.getId()) != null) {
			return mediaRepo.save(resource);
		}
		return null;
	}
}
