
import static org.junit.Assert.assertEquals;

import javax.management.loading.PrivateClassLoader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.spring.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import biz.MemberBiz;
import dto.MemberDto;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml", "classpath:servlet-context.xml"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	String memberDto;

	@org.junit.Test
	public void testUserController() throws Exception {
				//given
		/*
				String member_id = "eee";
				String password = "1234";
				String password2 = "1234";
				String address = "경기도 의정부시 금오동";
				String phone_number="01027378124";
				String email = "computer9302@gmail.com";
		*/	
		
				//when
		
		     	String memberDto = ((ResultActions) ((MockHttpServletRequestBuilder) mockMvc.perform(MockMvcRequestBuilders.post("/register")))
		     	.param("Id","eee")
		     	.param("password", "1234")
		     	.param("password2", "1234")
		     	.param("address", "경기도 의정부시 금오동")
		     	.param("phone_number", "010-2737-8124")
		     	.param("email", "computer9302@gmail.com")
		     	.contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse().getContentAsString();
				//then
				
		     	assertEquals("redirect:/login", memberDto);
			}
	
}		
