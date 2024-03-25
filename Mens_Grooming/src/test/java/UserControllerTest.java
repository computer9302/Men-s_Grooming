import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.controller.UserController;

import dto.MemberDto;
import junit.framework.Assert;

public class UserControllerTest {

	
	@Test
	public void testUserController() {
		//given
		UserController userController = new UserController();
		String memberDto;
		
		//when
		memberDto = userController.registerUser("b1", "1234", "1234", "의정부시 금오동", "01027378124", "computer9302@gmail.com");
		
		//then
		
		assertEquals(memberDto, "redirect:/login");
	}
	
}
