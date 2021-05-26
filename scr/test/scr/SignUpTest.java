package scr;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import program.SignUp;
import program.diagnose;

public class SignUpTest {

	public SignUp S = new SignUp();

	@Test
	public void testCheckConfirmPassword() {
		assertEquals(false, S.checkConfirmPassword("123", "1234"));
		assertEquals(true, S.checkConfirmPassword("1234", "1234"));
	}

	@Test
	public void testCheckUserName() {
		assertEquals(false, S.checkUserName("shayweitzman123"));
		assertEquals(true, S.checkUserName("shaywe12"));
		assertEquals(false, S.checkUserName("shaywe^%"));
	}

	@Test
	public void testCheckID() {
		assertEquals(false, S.checkID("123"));
		assertEquals(true, S.checkID("123456789"));
		assertEquals(false, S.checkID("12e3e3e^%"));
	}

	@Test
	public void testCheckPassword() {
		assertEquals(false, S.checkPassword("11111111"));
		assertEquals(true, S.checkPassword("123aaa##"));
		assertEquals(false, S.checkPassword("shay12345"));
	}

}
