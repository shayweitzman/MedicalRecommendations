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

public class addPatientTXT {
	private Map<Diseases, Integer> Diagnose;
	private Map<String, Boolean> boolsArray;
	private String patientName;
	private String patientAge;
	private String patientID;
	private String docName;

	public addPatientTXT(Map<Diseases, Integer> Diagnose, String docName, Map<String, Boolean> boolsArray,
			String patientName, String patientID, String patientAge) {
		this.Diagnose = Diagnose;
		this.docName = docName;
		this.boolsArray = boolsArray;
		this.patientName = patientName;
		this.patientID = patientID;
		this.patientAge = patientAge;
	}

	public void Write() {
		Path currentRelativePath = Paths.get("");
		File file = new File(
				currentRelativePath.toAbsolutePath().toString() + "//source//Patients//" + patientID + ".txt");
		try {

			FileWriter myWriter = new FileWriter(file, true);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			myWriter.write(formatter.format(date) + "\n");
			if (file.createNewFile()) {
				myWriter.write("Name: " + patientName + "\nID: " + patientID + "\n");
			}
			myWriter.write("Age: " + patientAge + "\n");
			myWriter.write("Treated by: Dr." + docName + "\n");
			int count = 0;
			for (String key : boolsArray.keySet()) {
				if (boolsArray.get(key) != null && boolsArray.get(key)) {
					count++;
					if (count == 1)
						myWriter.write("Details:\n");
					myWriter.write(key + "\t");
				}
			}
			myWriter.write("\n");
			boolean Healthy = true;
			count = 0;
			for (Diseases d : Diagnose.keySet()) {
				if (Diagnose.get(d) >= 5) {
					count++;
					if (count == 1)
						myWriter.write("Diagnoses: \n");
					myWriter.write("Diagnose High Risk: " + d + "\n");
					Healthy = false;
				} else if (Diagnose.get(d) > 3) {
					count++;
					if (count == 1)
						myWriter.write("Diagnoses: \n");
					myWriter.write("Diagnose Medium Risk: " + d + "\n");
					Healthy = false;
				} else if (Diagnose.get(d) > 0) {
					count++;
					if (count == 1)
						myWriter.write("Diagnoses: \n");
					myWriter.write("Diagnose Low Risk: " + d + "\n");
					Healthy = false;
				} else {
				}
			}
			if (Healthy)
				myWriter.write("No Diagnoses\n");

			myWriter.write("-------------------------------------------------------------------\n");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
