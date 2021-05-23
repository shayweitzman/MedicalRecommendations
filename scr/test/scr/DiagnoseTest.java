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
	JTextField nameField = new JTextField();
	JTextField idField = new JTextField();
	JTextField ageField = new JTextField();
	@Before
	public void setUp() {

	
		this.nameField.setText("shay");
		this.idField.setText("123456789");
		this.ageField.setText("35");
		d.dictionary.put("name", nameField);
		d.dictionary.put("id", idField);
		d.dictionary.put("age", ageField);

	}

	@Test
	public void testCheckInput() {
		//No Errors
		assertEquals(true, d.checkInput());	
		this.idField.setText("1");
		d.dictionary.put("id", idField);
		
		assertEquals(false, d.checkInput());//False because ID must be at least 9 digits
		this.idField.setText("123456789");
		d.dictionary.put("id", idField);
		this.ageField.setText("-1");
		d.dictionary.put("age", ageField);
		
		assertEquals(false, d.checkInput());//False because age can't be negative
		this.ageField.setText("35");
		d.dictionary.put("age", ageField);
		this.nameField.setText("shay3");
		d.dictionary.put("name", nameField);
		
		assertEquals(false, d.checkInput());//False because name can't contain negative
		
	}

	@Test
	public void testCheckNeut() {
		resetTotalDiagnose();
		d.checkNeut("100", "55");
		assertEquals(new Integer(3), d.totalDiagnose.get(Diseases.Infection));
		d.checkNeut("100", "17");
		assertEquals(new Integer(3), d.totalDiagnose.get(Diseases.Disorder_of_blood_formation));
		assertEquals(new Integer(6), d.totalDiagnose.get(Diseases.Infection));
		assertEquals(new Integer(1), d.totalDiagnose.get(Diseases.cancer));
	}
	
	@Test
	public void testCheckWBC()
	{
		resetTotalDiagnose();
		d.checkWBC("3500", 55);
		assertEquals(new Integer(3), d.totalDiagnose.get(Diseases.Viral_disease));
		assertEquals(new Integer(1), d.totalDiagnose.get(Diseases.cancer));
	}
	
	@Test
	public void testCheckLymph()
	{
		resetTotalDiagnose();
		d.checkLymph("100", "25");
		assertEquals(new Integer(3), d.totalDiagnose.get(Diseases.Disorder_of_blood_formation));
	}
	
	
	@Test
	public void resetTotalDiagnose()
	{
		for(Diseases di : d.totalDiagnose.keySet())
		{
			d.totalDiagnose.put(di,new Integer(0));
		}
	}
	

}
