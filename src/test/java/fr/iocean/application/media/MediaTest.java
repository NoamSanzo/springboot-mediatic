package fr.iocean.application.media;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.iocean.application.IntegrationTest;


@Sql("classpath:test-media-data.sql")
public class MediaTest extends IntegrationTest{

		
		@Autowired
		MediaService MediaService;
		
		@Test
//		@WithMockMedia(authorities="adminAuth")
		public void testCreate() throws Exception{
			Media u = new Media();
			u.setAuteur("Toto");
			u.setTitre("Toto l'aventurier");
			u.setType("livre");
			System.out.println("?????????????????????????testCreate!!!!!!!!!!!!!!!!!!!!!!!");

		this.mockMvc.perform(post("/api/Medias").contentType(MediaType.APPLICATION_JSON)
		.content(jsonHelper.serialize(u)))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().is(201));
		
		
		this.mockMvc.perform(get("/api/Medias")).andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(4)));
		}
		
		@Test
//		@WithMockMedia
		public void testCreateR() throws Exception{
			Media u = new Media();
			u.setAuteur("Toto");
			u.setTitre("Toto l'aventurier the Return");
			u.setType("livre");
	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!testCreateR!!!!!!!!!!!!!!!!!!!!!!!");

		this.mockMvc.perform(post("/api/Medias").contentType(MediaType.APPLICATION_JSON)
		.content(jsonHelper.serialize(u)))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().is(403));

	}
}
