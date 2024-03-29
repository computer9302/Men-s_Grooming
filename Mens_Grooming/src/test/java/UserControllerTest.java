import static org.junit.Assert.assertEquals;

import javax.management.loading.PrivateClassLoader;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import biz.MemberBiz;
import dto.MemberDto;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml", "classpath:servlet-context.xml"})
public class UserControllerTest {

	
	private final UserController userController; 

	@Autowired
	public UserControllerTest() {
		this.userController = new UserController();
	}


	public void testUserController() {
				//given
				String member_id = "b1";
				String pass_word = "1234";
				String pass_word2 = "1234";
				String address = "의정부시 오목로";
				String phone_number = "010-2737-8124";
				String e_mail = "computer9302@gmail.com";
		
		
				//when
				String memberDto = userController.registerUser(member_id, pass_word, pass_word2, address, phone_number, e_mail);
				
				//then
				
				assertEquals(memberDto, "redirect:/login");
			}
	
}		
