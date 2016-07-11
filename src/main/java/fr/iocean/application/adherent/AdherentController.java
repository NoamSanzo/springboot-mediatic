package fr.iocean.application.adherent;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adherent")
public class AdherentController {

	@Autowired
	private AdherentService adherentService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Adherent findById(@PathVariable Long id) {
		return adherentService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Adherent> findAll() {
		return adherentService.findAll();
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody @Valid Adherent resource) {
		adherentService.create(resource);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	public Adherent update(@RequestBody @Valid Adherent resource,@PathVariable Long id){
		return adherentService.update(resource);
	}

}
