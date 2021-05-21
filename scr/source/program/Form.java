package program;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public abstract class Form {
	protected JFrame SignUpframe;
	protected JTextField txtUserName;
	protected JTextField txtPassword;
	protected JTextField txtId;
	
	public Form(JFrame SignUpframe, JTextField txtUserName, JTextField txtPassword, JTextField txtId) {
		this.SignUpframe = SignUpframe;
		this.txtUserName = txtUserName;
		this.txtPassword = txtPassword;
		this.txtId = txtId;
	}
	
	protected boolean checkUserName(String userName) {
		if(userName.length() < 6 || userName.length() > 8) {
			JOptionPane.showMessageDialog(SignUpframe, "Username must be between 6 - 8 characters","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		int count =0;
		for(int i=0;i<userName.length();i++) {
			if(Character.isDigit(userName.charAt(i)))
				count++;
			else if(!Character.isLetter(userName.charAt(i))) {
				JOptionPane.showMessageDialog(SignUpframe, "Username can contain letters and numbers only","Warning", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		if(count > 2) {
			JOptionPane.showMessageDialog(SignUpframe, "Username must contain 2 digits max","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;

	}
	
	protected boolean checkID(String id) {
		if(id.length() != 9) {
			JOptionPane.showMessageDialog(SignUpframe, "ID must be 9 characters","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			try {
				int x = Integer.parseInt(id);
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(SignUpframe, "ID must be numbers only","Warning", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	protected boolean checkPassword(String password) {
		if(password.length() < 8 || password.length() > 10) {
			JOptionPane.showMessageDialog(SignUpframe, "Password must be between 8 - 10 characters","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		int letter=0,special=0,digit=0;
		for(int i=0;i<password.length();i++) {
			if(Character.isLetter(password.charAt(i)))
				letter++;
			else if(Character.isDigit(password.charAt(i)))
				digit++;
			else
				special++;
		}
		if(letter < 1 || digit < 1 || special < 1) {
			JOptionPane.showMessageDialog(SignUpframe, "Password must contain at least one letter, digit and special characters","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}
