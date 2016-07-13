package fr.iocean.application.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/media")
@Transactional
public class MediaController {

	@Autowired
	private MediaService mediaService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Media findOne(@PathVariable Long id) {
		return mediaService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Media> findAll() {
		return mediaService.findAll();
	}

	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Media resource) {
		mediaService.create(resource);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@RequestBody Media resource) {
		mediaService.update(resource);
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<Media> search(@RequestParam(value = "titre", required = false)String titre, 
			@RequestParam(value = "type", required = false) String type, 
			@RequestParam(value = "auteur", required = false) String auteur ){
		
		return mediaService.search(titre, type, auteur);	
	}
	
}
