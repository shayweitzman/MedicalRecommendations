package scr;

import static org.junit.Assert.*;

import org.junit.Test;

import program.LogIn;
import program.SignUp;

public class LoginTest {

	public LogIn l = new LogIn();
	@Test
	public void testCheckUserName() {
		assertEquals(false,l.checkUserName("shayweitzman123"));
		assertEquals(true,l.checkUserName("shaywe12"));
		assertEquals(false,l.checkUserName("shaywe^%"));
	}
	@Test
	public void testCheckID() {
		assertEquals(false,l.checkID("123"));
		assertEquals(true,l.checkID("123456789"));
		assertEquals(false,l.checkID("12e3e3e^%"));
	}
	@Test
	public void testCheckPassword() {
		assertEquals(false,l.checkPassword("11111111"));
		assertEquals(true,l.checkPassword("123aaa##"));
		assertEquals(false,l.checkPassword("shay12345"));
	}

}
