/**
 * 
 */
package fr.iocean.application.media;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.iocean.application.IntegrationTest;
import fr.iocean.application.media.Media;
import fr.iocean.application.media.MediaService;

@Sql("classpath:test-media-data.sql")
public class MediaIT extends IntegrationTest{
	@Autowired
	MediaService mediaService;
	
	
	@Test
	@WithMockUser(authorities="ADMIN")
	public void testCreate() throws Exception{
		Media media = new Media();
		media.setTitre("titre");
		media.setType("type");
		media.setAuteur("auteur");
	
		this.mockMvc.perform(post("/api/media").contentType(MediaType.APPLICATION_JSON)
				.content(jsonHelper.serialize(media)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(201));
		
		this.mockMvc.perform(get("/api/media")).andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(4)));
		}
		
		@Test
		@WithMockUser
		public void testCreateForbidden() throws Exception{
			Media media = new Media();
			media.setTitre("titre");
			media.setType("type");
			media.setAuteur("auteur");

		this.mockMvc.perform(post("/api/media").contentType(MediaType.APPLICATION_JSON)
		.content(jsonHelper.serialize(media)))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().is(403));

}}
	


