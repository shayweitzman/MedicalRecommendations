package program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class diagnose implements ActionListener {
	private Map<String, JTextField> dictionary;
	private Map<Diseases, Integer> totalDiagnose;
	private JFrame frame;
	private Boolean smoker = null;
	private Boolean pregnant = null;
	private Boolean fever = null;
	private Boolean ethiopian = null;
	private Boolean NAfrica = null;
	
	public static final int COMMON = 3;
	public static final int RARE = 1;
	
	public diagnose(JFrame frame,JTextField name, JTextField PId, JTextField age, JTextField WBC, JTextField neut, JTextField lymph, JTextField Urea,
			JTextField RBC, JTextField hb, JTextField creatinie,JTextField iron, JTextField HDL, JTextField AP){
		this.frame = frame;
		this.dictionary = new HashMap<String, JTextField>();
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
		
		this.totalDiagnose = new HashMap<Diseases, Integer>();
		
		totalDiagnose.put(Diseases.anemia, 0);
		totalDiagnose.put(Diseases.diet, 0);
		totalDiagnose.put(Diseases.bleeding, 0);
		totalDiagnose.put(Diseases.Hyperlipidemia, 0);
		totalDiagnose.put(Diseases.Disorder_of_blood_formation, 0);
		totalDiagnose.put(Diseases.Hematological_disorder, 0);
		totalDiagnose.put(Diseases.Iron_poisoning, 0);
		totalDiagnose.put(Diseases.Dehydration, 0);
		totalDiagnose.put(Diseases.Infection, 0);
		totalDiagnose.put(Diseases.Vitamin_deficiency, 0);
		totalDiagnose.put(Diseases.Viral_disease, 0);
		totalDiagnose.put(Diseases.Diseases_of_the_biliary_tract, 0);
		totalDiagnose.put(Diseases.heart_diseases , 0);
		totalDiagnose.put(Diseases.Blood_disease, 0);
		totalDiagnose.put(Diseases.Liver_disease, 0);
		totalDiagnose.put(Diseases.Kidney_disease, 0);
		totalDiagnose.put(Diseases.Iron_deficiency, 0);
		totalDiagnose.put(Diseases.Muscle_diseases, 0);
		totalDiagnose.put(Diseases.Smoker, 0);
		totalDiagnose.put(Diseases.Lung_disease, 0);
		totalDiagnose.put(Diseases.Overactive_thyroid_gland, 0);
		totalDiagnose.put(Diseases.Adult_diabetes, 0);
		totalDiagnose.put(Diseases.cancer, 0);
		totalDiagnose.put(Diseases.Increased_consumption_of_meat, 0);
		totalDiagnose.put(Diseases.Use_of_various_medications, 0);
		totalDiagnose.put(Diseases.Malnutrition , 0);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(checkInput()) {
			checkWBC(this.dictionary.get("WBC").getText(), Integer.parseInt(this.dictionary.get("age").getText()));
			for(Diseases i : this.totalDiagnose.keySet())
				System.out.println(i + ": " + this.totalDiagnose.get(i));
			this.frame.dispose();
		}
		
	}
	
	private void checkWBC(String WBC, int age) {
		if(WBC.length() == 0)
			return;
		int val = Integer.parseInt(WBC);
		int max,min;
		if(age >= 18) {
			min = 4500;
			max = 11000;
		}
		else if (age >= 4){
			min = 5500;
			max = 15500;
		}
		else {
			min = 6000;
			max = 17500;
		}
		Boolean range = Value_range(val, max, min);
		if(range == null)
			return;
		if(range) {
			if(fever == null) {
				int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to exit?", "Swing Tester",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				this.fever = result == JOptionPane.YES_OPTION;
			}
			if(fever) {
				addRisk(Diseases.Infection, COMMON);
			}
			addRisk(Diseases.Blood_disease, RARE);
			addRisk(Diseases.cancer, RARE);
		}
		else {
			addRisk(Diseases.Viral_disease, COMMON);
			addRisk(Diseases.cancer, RARE);
			
		}
			

	}
	
	private void addRisk(Diseases d, int range) {
		this.totalDiagnose.put(d,this.totalDiagnose.get(d)+range);
	}
	
	private Boolean Value_range(int val,int max,int min) {
		if(val >= min && val <= max)
			return null;
		if(val < min)
			return false;
		return true;
	}
	
	private boolean checkInput() {
		if(this.dictionary.get("name").getText().length() == 0 ||this.dictionary.get("id").getText().length()==0 || this.dictionary.get("age").getText().length()==0) {
			JOptionPane.showMessageDialog(this.frame, "patient mast have at least age name and id" ,"Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		try {
			for(String key : this.dictionary.keySet()) {
				if(key.equals("id") && this.dictionary.get(key).getText().length() != 9)
					throw new Exception();
				if(!key.equals("name") && this.dictionary.get(key).getText().length() > 0) {
					Integer.parseInt(this.dictionary.get(key).getText());
				}
			}
			return true;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(this.frame, "Form Invalid" ,"Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	

}
