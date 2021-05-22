package scr;

import static org.junit.Assert.*;

import java.util.HashMap;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import program.Diseases;
import program.diagnose;

public class DiagnoseTest {
	public diagnose d = new diagnose();

	@Before
	public void setUp() {

		JTextField nameField = new JTextField();
		JTextField idField = new JTextField();
		JTextField ageField = new JTextField();
		nameField.setText("shay");
		idField.setText("123456789");
		ageField.setText("35");
		d.dictionary.put("name", nameField);
		d.dictionary.put("id", idField);
		d.dictionary.put("age", ageField);

	}

	@Test
	public void testCheckInput() {
		assertEquals(true, d.checkInput());
		JTextField idField = new JTextField();
		idField.setText("1");
		d.dictionary.put("id", idField);
		assertEquals(false, d.checkInput());
	}

	@Test
	public void testCheckNeut() {
		d.checkNeut("100", "55");
		assertEquals(new Integer(3), d.totalDiagnose.get(Diseases.Infection));
		d.checkNeut("100", "17");
		assertEquals(new Integer(3), d.totalDiagnose.get(Diseases.Disorder_of_blood_formation));
		assertEquals(new Integer(6), d.totalDiagnose.get(Diseases.Infection));
		assertEquals(new Integer(1), d.totalDiagnose.get(Diseases.cancer));
	}

}
