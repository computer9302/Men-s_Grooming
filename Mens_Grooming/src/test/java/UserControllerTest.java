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
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml", "classpath:servlet-context.xml"})
public class UserControllerTest {

	
	private final UserController userController; 
	private final MemberBiz memberBizMock;
	
	public UserControllerTest() {
		this.memberBizMock = mock(MemberBiz.class);
		this.userController = new UserController(memberBizMock);
	}


	@Test
	public void testUserController() {
				//given
				String member_id = "eee";
				String password = "1234";
				String password2 = "1234";
				String address = "의정부시 오목로";
				String phone_number = "010-2737-8124";
				String e_mail = "computer9302@gmail.com";
		
		
				//when
				String memberDto = userController.registerUser(member_id, password, password2, address, phone_number, e_mail);
				
				//then
				
				assertEquals("redirect:/login", memberDto);
			}
	
}		
