package program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LogIn implements ActionListener {
	private JFrame SignInframe;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtId;
	
	public LogIn(JFrame SignInframe, JTextField txtUserName, JTextField txtPassword, JTextField txtId) {
		this.SignInframe = SignInframe;
		this.txtUserName = txtUserName;
		this.txtPassword = txtPassword;
		this.txtId = txtId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		checkUserName(txtUserName.getText());
		checkPassword(txtPassword.getText());
		checkID(this.txtId.getText());
		
		
		
		
	}
	
	private void checkUserName(String userName) {
		if(userName.length() < 6 || userName.length() > 8) {
			JOptionPane.showMessageDialog(SignInframe, "User name must be between 6 and 8 characters","Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int count =0;
		for(int i=0;i<userName.length();i++) {
			if(Character.isDigit(userName.charAt(i)))
				count++;
			else if(!Character.isLetter(userName.charAt(i))) {
				JOptionPane.showMessageDialog(SignInframe, "User name must contain letters and numbers only","Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		if(count > 2)
			JOptionPane.showMessageDialog(SignInframe, "User name must contain 2 digits max","Warning", JOptionPane.WARNING_MESSAGE);

	}
	
	private void checkID(String id) {
		if(id.length() != 9)
			JOptionPane.showMessageDialog(SignInframe, "ID must be 9 characters","Warning", JOptionPane.WARNING_MESSAGE);
		else {
			try {
				int x = Integer.parseInt(id);
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(SignInframe, "ID must be numbers only","Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private void checkPassword(String password) {
		if(password.length() < 8 || password.length() > 10) {
			JOptionPane.showMessageDialog(SignInframe, "password must be between 8 and 10 characters","Warning", JOptionPane.WARNING_MESSAGE);
			return;
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
		if(letter < 1 || digit < 1 || special < 1)
			JOptionPane.showMessageDialog(SignInframe, "password must be contain at least one letter, digit amd special chrecter","Warning", JOptionPane.WARNING_MESSAGE);

		
	}

}
