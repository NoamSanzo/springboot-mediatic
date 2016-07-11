package fr.iocean.application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import fr.iocean.application.helper.JsonHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FilRougeApplication.class)
@WebAppConfiguration
@Transactional
public abstract class IntegrationTest {
	
	@Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    protected JsonHelper jsonHelper = new JsonHelper();

    @Before
    public void initMockMcv() {
        mockMvc = MockMvcBuilders
        		.webAppContextSetup(webApplicationContext)
        		.apply(SecurityMockMvcConfigurers.springSecurity())
        		.build();
    }
	
}
