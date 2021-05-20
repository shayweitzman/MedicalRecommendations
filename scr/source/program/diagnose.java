package program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

public class diagnose implements ActionListener {
	private Map<String, String> dictionary;
	
	public diagnose(String name, String PId, String age, String WBC, String neut, String lymph, String Urea, String RBC, String hb, String creatinie,
	String iron, String HDL, String AP){
		this.dictionary = new HashMap<String, String>();
		dictionary.put("name", name);
		dictionary.put("id", PId);
		dictionary.put("age", age);
		dictionary.put("WBC", WBC);
		dictionary.put("neut", neut);
		dictionary.put("lymph", lymph);
		dictionary.put("Urea", Urea);
		dictionary.put("RBC", RBC);
		dictionary.put("hb", hb);
		dictionary.put("creatinie", creatinie);
		dictionary.put("iron", iron);
		dictionary.put("HDL", HDL);
		dictionary.put("AP", AP);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean smoker = null;
		Boolean pregnant = null;
		Boolean fever = null;
		Boolean ethiopian = null;
		Boolean NAfrica = null;
		
		
	}
	

}
