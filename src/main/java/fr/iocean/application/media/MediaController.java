package fr.iocean.application.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource/media.accession")
public class MediaController {

	@Autowired
	private MediaService mediaService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Media findOne(@PathVariable Long id) {
		return mediaService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Media resource) {
		mediaService.create(resource);
	}
	
}