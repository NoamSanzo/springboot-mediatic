/**
 * 
 */
package fr.iocean.application.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.iocean.application.IntegrationTest;
import fr.iocean.application.authorization.Authorization;
import fr.iocean.application.user.service.UserService;

@Sql("classpath:test-user-data.sql")
public class UserIT extends IntegrationTest{
	@Autowired
	UserService userService;
	
	
	@Test
	@WithMockUser(authorities="ADMIN")
	public void testCreate() throws Exception{
		User user = new User();
		user.setLogin("billy");
		user.setPassword("billy");
		user.setName("billy");
	
		this.mockMvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON)
				.content(jsonHelper.serialize(user)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(201));
	}
	
	@Test
	@WithMockUser
	public void testGetAuthorizations()throws Exception{
		User user = new User();
		user.setLogin("billy2");
		user.setPassword("billy2");
		user.setName("billy2");
		
		List<Authorization> auth = new ArrayList<Authorization>();
		Authorization authAdmin = new Authorization();
		authAdmin.setCode("ADMIN");
		Authorization authUser = new Authorization();
		authUser.setCode("USER");
		auth.add(authUser);
		auth.add(authAdmin);
		user.setAuthorizations(auth);
		
		this.mockMvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON)
				.content(jsonHelper.serialize(user)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(201));
		
		
	}
//	@Test
//	@WithMockUser
//	public void testCreateForbidden() throws Exception{
//			Media media = new Media();
//			media.setTitre("titre");
//			media.setType("type");
//			media.setAuteur("auteur");
//
//		this.mockMvc.perform(post("/api/media").contentType(MediaType.APPLICATION_JSON)
//		.content(jsonHelper.serialize(media)))
//		.andDo(MockMvcResultHandlers.print())
//		.andExpect(status().is(403));
//
//}
}


