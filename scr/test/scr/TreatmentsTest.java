package scr;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import program.Diseases;
import program.Treatments;
public class TreatmentsTest {
	
	private Map<Diseases, Integer> totalDiagnose = new HashMap<Diseases, Integer>();
	private Treatments t;
	@Before
	public void setUp() {
		totalDiagnose.put(Diseases.Infection, 2);
		totalDiagnose.put(Diseases.cancer, 12);
		totalDiagnose.put(Diseases.Blood_disease,0);
		totalDiagnose.put(Diseases.diet, 4);
		this.t = new Treatments(totalDiagnose);
	;

	}
	@Test
	public void test() {
		assertEquals("Entrectinib.",t.personalTreatment.get(Diseases.cancer));
		assertEquals("Dedicated antibiotics.",t.personalTreatment.get(Diseases.Infection));
		assertEquals(null,t.personalTreatment.get(Diseases.Blood_disease));
		assertEquals("Schedule an appointment with a nutritionist.",t.personalTreatment.get(Diseases.diet));
	}

}
