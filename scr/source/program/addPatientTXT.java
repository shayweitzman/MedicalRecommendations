package program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JFrame;

import GUI.DiagnoseFrame;
import GUI.MainFrame;

public class addPatientTXT {
	private Map<Diseases, Integer> Diagnose;
	private Map<String, Boolean> boolsArray;
	private String patientName;
	private String patientAge;
	private String patientID;
	private String docName;
	private MainFrame user;
	private Treatments personalTreatment;

	public addPatientTXT(MainFrame user, Treatments personalTreatment, Map<Diseases, Integer> Diagnose, String docName,
			Map<String, Boolean> boolsArray, String patientName, String patientID, String patientAge) {
		this.Diagnose = Diagnose;
		this.docName = docName;
		this.personalTreatment = personalTreatment;
		this.boolsArray = boolsArray;
		this.patientName = patientName;
		this.patientID = patientID;
		this.patientAge = patientAge;
		this.user = user;
	}

	public void Write() {
		Path currentRelativePath = Paths.get("");
		File file = new File(
				currentRelativePath.toAbsolutePath().toString() + "//source//Patients//" + patientID + ".txt");
		String results = generateDiagnose().toString();
		try {

			FileWriter myWriter = new FileWriter(file, true);
			myWriter.write(results);
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DiagnoseFrame show = new DiagnoseFrame(user, results, this.patientID, this.docName, this.patientName);

	}

	private StringBuffer generateDiagnose() {
		StringBuffer results = new StringBuffer();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		results.append(formatter.format(date) + "\n");
		results.append("Name: " + patientName + "\nID: " + patientID + "\n" + "Age: " + patientAge + "\n"
				+ "Treated by: Dr." + docName + "\n");
		int count = 0;
		for (String key : boolsArray.keySet()) {
			if (boolsArray.get(key)) {
				count++;
				if (count == 1)
					results.append("Details:\n");
				results.append(key + "  ");
			}
		}
		results.append("\n");
		StringBuffer HighRisk = new StringBuffer();
		StringBuffer MediumRisk = new StringBuffer();
		StringBuffer LowRisk = new StringBuffer();
		boolean Healthy = true;
		for (Diseases d : Diagnose.keySet()) {
			if (Diagnose.get(d) >= 3) {
				HighRisk.append("\t" + d.toString().replaceAll("_", " ") + " ---> Recommended Treatment: "
						+ personalTreatment.personalTreatment.get(d) + "\n");
				Healthy = false;
			} else if (Diagnose.get(d) == 2) {
				MediumRisk.append("\t" + d.toString().replaceAll("_", " ") + " ---> Recommended Treatment: "
						+ personalTreatment.personalTreatment.get(d) + "\n");
				Healthy = false;
			} else if (Diagnose.get(d) > 0) {
				LowRisk.append("\t" + d.toString().replaceAll("_", " ") + " ---> Recommended Treatment: "
						+ personalTreatment.personalTreatment.get(d) + "\n");
				Healthy = false;
			}
		}
		if (Healthy) {
			results.append("No Diagnoses\n");
		} else {
			if (HighRisk.length() > 0) {
				results.append("\nDiagnose High Risk:\n");
				results.append(HighRisk);
			}
			if (MediumRisk.length() > 0) {
				results.append("\nDiagnose Medium Risk:\n");
				results.append(MediumRisk);
			}
			if (LowRisk.length() > 0) {
				results.append("\nDiagnose Low Risk:\n");
				results.append(LowRisk);
			}
		}
		results.append("-------------------------------------------------------------------\n");
		return results;

	}

}
