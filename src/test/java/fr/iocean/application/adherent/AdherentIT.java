package fr.iocean.application.adherent;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.iocean.application.IntegrationTest;
import fr.iocean.application.adherent.Adherent;
import fr.iocean.application.adherent.AdherentService;
import fr.iocean.application.adherent.Cotisation;

@Sql("classpath:test-adherent-data.sql")
public class AdherentIT extends IntegrationTest{
	
	@Autowired
	AdherentService adherentService;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	@WithMockUser(authorities="ADMIN")
	public void testCreate() throws Exception{
		Adherent adherent = new Adherent();
		adherent.setNom("nom");
		adherent.setPrenom("prenom");
		adherent.setAdresse("adresse");
		Cotisation c = new Cotisation();
		c.setDebut(formatter.parse("2016-01-01"));
		c.setFin(formatter.parse("2017-01-01"));
		c.setMontant(new Double(200));
		adherent.setCotisation(c);
		adherent.setAge(12);
		adherent.setDate_naissance(new Date());
		adherent.setEmail("aaaa@email.com");
		adherent.setNombre_media(10);
		
		
		this.mockMvc.perform(post("/api/adherent").contentType(MediaType.APPLICATION_JSON)
				.content(jsonHelper.serialize(adherent)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(201));
		
		this.mockMvc.perform(get("/api/adherent")).andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(4)));
		}
		
		@Test
		@WithMockUser()
		public void testCreateForbidden() throws Exception{
			Adherent adherent = new Adherent();
			adherent.setNom("nom");
			adherent.setPrenom("prenom");
			adherent.setAdresse("adresse");
			Cotisation c = new Cotisation();
			c.setDebut(formatter.parse("2016-01-01"));
			c.setFin(formatter.parse("2017-01-01"));
			c.setMontant(new Double(200));
			adherent.setCotisation(c);
			adherent.setAge(12);
			adherent.setDate_naissance(new Date());
			adherent.setEmail("aaaa@email.com");
			adherent.setNombre_media(10);


		this.mockMvc.perform(post("/api/adherent").contentType(MediaType.APPLICATION_JSON)
		.content(jsonHelper.serialize(adherent)))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().is(403));

}}
	
