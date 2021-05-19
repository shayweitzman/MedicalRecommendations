package Database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Database {
	private String username;
	private String password;
	private String docID;
	

	public Database(String username, String password, String docID) {
		this.username = username;
		this.password = password;
		this.docID = docID;
	
	}

	public void Read() {
		String line = "";
		String splitBy = ",";
		Path currentRelativePath = Paths.get("");
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(
					new FileReader(currentRelativePath.toAbsolutePath().toString() + "//Database//Users.csv"));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				System.out.println(line);
				String[] l = line.split(splitBy); // use comma as separator
				System.out.println(
						"Employee [First Name=" + l[0] + ", Last Name=" + l[1] + ", Designation=" + l[2] + "]");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isExist(String s1, int index) {
		String line = "";
		String splitBy = ",";
		Path currentRelativePath = Paths.get("");
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(
					new FileReader(currentRelativePath.toAbsolutePath().toString() + "//Database//Users.csv"));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] l = line.split(splitBy); // use comma as separator
				if (l[index].equals(s1))
					return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String Write() {
		Path currentRelativePath = Paths.get("");
		File file = new File(currentRelativePath.toAbsolutePath().toString() + "//Database//Users.csv");
		if (isExist(this.docID,0))
		{
			return "This ID is Already Taken";
		}
		else if(isExist(this.username,1))
		{
			return "This Username is Already Taken";
		}
		else
		{
			try {
				FileWriter output = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(output);
				PrintWriter pw = new PrintWriter(bw);
				pw.println(docID + "," + username + "," + password);
				pw.flush();
				pw.close();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
		}
		return "Signed Up Successfully";
		
	}

}