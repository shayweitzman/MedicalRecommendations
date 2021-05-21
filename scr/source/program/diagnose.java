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
	private Boolean man = null;
	private Boolean pregnant = null;
	private Boolean fever = null;
	private Boolean ethiopian = null;
	private Boolean NAfrica = null;
	private Boolean Diarrhea = null;
	
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
	
	private void addRisk(Diseases d, int range) {
		this.totalDiagnose.put(d,this.totalDiagnose.get(d)+range);
	}
	
	private Boolean forward_question(Boolean bol, String msg){
		if(bol != null)
			return bol;
		int result = JOptionPane.showConfirmDialog(frame,msg, "Forward Question",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		return result == JOptionPane.YES_OPTION;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(checkInput()) {
			
			checkWBC(this.dictionary.get("WBC").getText(), Integer.parseInt(this.dictionary.get("age").getText()));
			checkNeut(this.dictionary.get("WBC").getText(), this.dictionary.get("neut").getText());
			checkLymph(this.dictionary.get("WBC").getText(), this.dictionary.get("lymph").getText());
			checkRBC(this.dictionary.get("RBC").getText());
			checkHCT(this.dictionary.get("RBC").getText(), this.dictionary.get("WBC").getText());
			checkUrea(this.dictionary.get("Urea").getText());
			checkCreatinie(this.dictionary.get("creatinie").getText(), Integer.parseInt(this.dictionary.get("age").getText()));
			checkIron(this.dictionary.get("iron").getText());
			checkHDL(this.dictionary.get("HDL").getText());
			//checkHDL(this.dictionary.get("HDL").getText());
			
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
		if(val >= min && val <= max)
			return;
		if(val > max) {
			this.fever = forward_question(fever, "Does the patient suffer from fever?");
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
	
	private void checkNeut(String WBC, String neut) {
		if(WBC.length() == 0 || neut.length() == 0 || Integer.parseInt(WBC) == 0)
			return;
		double precent = (double)Integer.parseInt(neut)/Integer.parseInt(WBC);
		if(precent >= 28 && precent <= 54)
			return;
		if(precent < 28) {
			addRisk(Diseases.Disorder_of_blood_formation,COMMON);
			addRisk(Diseases.Infection,COMMON);//Bacterial infection
			addRisk(Diseases.cancer,RARE);
		}
		else
			addRisk(Diseases.Infection,COMMON);//Bacterial infection
	}
	
	private void checkLymph(String WBC, String Lymph) {
		if(WBC.length() == 0 || Lymph.length() == 0 || Integer.parseInt(WBC) == 0)
			return;
		double precent = Double.parseDouble(Lymph)/Double.parseDouble(WBC);
		if(precent >= 36 && precent <= 52)
			return;
		if(precent < 36)
			addRisk(Diseases.Disorder_of_blood_formation,COMMON);
		else {
			addRisk(Diseases.cancer,COMMON);// Lymphoma cancer
			addRisk(Diseases.Disorder_of_blood_formation,COMMON);// Bacterial infection
		}
		
	}
	
	private void checkRBC(String RBC) {
		if(RBC.length() == 0)
			return;
		double val = Double.parseDouble(RBC);
		if(val >= 4.5 && val <= 6) 
			return;
		if(val > 6) {
			this.smoker = forward_question(smoker, "Do the patient smoke?");
			if(this.smoker)
				addRisk(Diseases.Smoker,COMMON);
			addRisk(Diseases.Disorder_of_blood_formation,COMMON);
			addRisk(Diseases.Lung_disease,COMMON);
		}
		else {
			addRisk(Diseases.anemia,COMMON);
			addRisk(Diseases.bleeding,COMMON);
		}
	}
	
	private void checkHCT(String RBC, String WBC) {
		if(WBC.length() == 0 || RBC.length() == 0 || Integer.parseInt(WBC) == 0)
			return;
		double precent = Double.parseDouble(RBC)/(Double.parseDouble(WBC) + Double.parseDouble(RBC));
		this.man = forward_question(man, "Does the patient male?");
		int max, min;
		if(this.man) {
			max = 54;
			min = 37;
		}
		else {
			max = 47;
			min = 33;
		}
		if(precent >= min && precent <= max)
			return;
		if(precent > max) {
			this.smoker = forward_question(smoker, "Does the patient smoke?");
			if(this.smoker)
				addRisk(Diseases.Smoker,COMMON);
		}
		else {
			addRisk(Diseases.anemia,COMMON);
			addRisk(Diseases.bleeding,COMMON);
		}
	}
	
	private void checkUrea(String Urea) {
		if(Urea.length() == 0)
			return;
		int min = 17,max = 43;
		this.NAfrica = forward_question(NAfrica, "Does the patient have oriental roots?");
		if(this.NAfrica)
			max *= 1.1;
		int val = Integer.parseInt(Urea);
		if(val >= min && val <= max)
			return;
		if(val > max) {
			addRisk(Diseases.Kidney_disease,COMMON);
			addRisk(Diseases.Dehydration,COMMON);
			addRisk(Diseases.diet,COMMON);
		}
		else {
			this.pregnant = forward_question(pregnant, "Does the patient pregnant?");
			if(this.pregnant) {
				addRisk(Diseases.Malnutrition,RARE);
				addRisk(Diseases.diet,RARE);
				addRisk(Diseases.Liver_disease,RARE);
			}
			else {
				addRisk(Diseases.Malnutrition,COMMON);
				addRisk(Diseases.diet,COMMON);
				addRisk(Diseases.Liver_disease,COMMON);
			}
		}
	}
	
	private void checkHb(String hb, int age) {
		if(hb.length() == 0)
			return;
		double min,max;
		if(age <= 17) {
			min = 11.5;
			max = 15.5;
		}
		this.man = forward_question(man, "Does the patient male?");
		if(this.man) {
			max = 18;
			min = 12;
		}
		else {
			max = 16;
			min = 12;
		}
		if(Double.parseDouble(hb) < min) {
			addRisk(Diseases.anemia,COMMON);
			addRisk(Diseases.Hematological_disorder,COMMON);
			addRisk(Diseases.Iron_deficiency,COMMON);
			addRisk(Diseases.bleeding,COMMON);
		}
			
	}
	
	private void checkCreatinie(String creatinie, int age) {
		if(creatinie.length() == 0)
			return;
		double max, min;
		if(age < 2) {
			min = 0.2;
			max = 0.5;
		}
		else if(age < 17) {
			min = 0.5;
			max = 1;
		}
		else if(age < 59) {
			min = 0.6;
			max = 1;
		}
		else {
			min = 0.6;
			max = 1.2;
		}
		double val = Double.parseDouble(creatinie);
		if(val >= min && val <= max)
			return;
		if(val > max) {
			this.Diarrhea = forward_question(Diarrhea, "Does the patient suffer from diarrhea?");
			if(Diarrhea) {
				addRisk(Diseases.Kidney_disease,RARE);
				addRisk(Diseases.Increased_consumption_of_meat,RARE);
				addRisk(Diseases.Muscle_diseases,RARE);
			}
			else {
				addRisk(Diseases.Kidney_disease,COMMON);
				addRisk(Diseases.Increased_consumption_of_meat,COMMON);
				addRisk(Diseases.Muscle_diseases,COMMON);
			}
		}
		else {
			addRisk(Diseases.Malnutrition,COMMON);
		}
		
	}
	
	private void checkIron(String iron) {
		if(iron.length() == 0)
			return;
		int min = 60, max = 160;
		this.man = forward_question(man, "Does the patient male?");
		if(this.man) {
			min *= 0.8;
		}
		int val = Integer.parseInt(iron);
		if(val >= min && val <= max) 
			return;
		if(val > max) {
			addRisk(Diseases.Iron_poisoning,COMMON);
		}
		else {
				this.pregnant = forward_question(pregnant, "Does the patient pregnant?");
				if(this.pregnant) {
					addRisk(Diseases.diet,RARE);
					addRisk(Diseases.bleeding,RARE);
			}
				else {
					addRisk(Diseases.diet,COMMON);
					addRisk(Diseases.bleeding,COMMON);
				}
		}
		
	}
	
	void checkHDL(String HDL) {
		if(HDL.length() == 0)
			return;
		int min,max;
		this.man = forward_question(man, "Does the patient male?");
		if(this.man) {
			min = 29;
			max = 62;
		}
		else {
			min = 34;
			max = 82;
		}
		this.ethiopian = forward_question(ethiopian, "Does the patient have ethiopian roots?");
		if(this.ethiopian) {
			max *= 1.2;
		}
		int val = Integer.parseInt(HDL);
		if(val < min) {
			addRisk(Diseases.heart_diseases,COMMON);
			addRisk(Diseases.Hyperlipidemia,COMMON);
			addRisk(Diseases.Adult_diabetes,COMMON);
		}
		
	}
	
	void checkAP(String AP) {
		if(AP.length() == 0)
			return;
		int min = 30, max = 90;
		this.NAfrica = forward_question(NAfrica, "Does the patient have oriental roots?");
		if(this.NAfrica) {
			min = 60;
			max = 120;
		}
		int val = Integer.parseInt(AP);
		if(val >= min && val <= max)
			return;
		if(val > max) {
			this.pregnant = forward_question(pregnant, "Does the patient pregnant?");
			if(!this.pregnant) {
				addRisk(Diseases.Liver_disease,COMMON);
				addRisk(Diseases.Diseases_of_the_biliary_tract,COMMON);
				addRisk(Diseases.Adult_diabetes,COMMON);
				addRisk(Diseases.Overactive_thyroid_gland,COMMON);
				addRisk(Diseases.Use_of_various_medications,COMMON);
			}
		}
		else {
			addRisk(Diseases.diet,COMMON);
			addRisk(Diseases.Vitamin_deficiency,COMMON);
		}
	}
	
	
	
	
	
//	private Boolean Value_range(int val,int max,int min) {
//		if(val >= min && val <= max)
//			return null;
//		if(val < min)
//			return false;
//		return true;
//	}
	
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
					Double.parseDouble(this.dictionary.get(key).getText());
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