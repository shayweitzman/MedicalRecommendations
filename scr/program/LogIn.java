package program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LogIn extends Form implements ActionListener {

	
	public LogIn(JFrame SignInframe, JTextField txtUserName, JTextField txtPassword, JTextField txtId) {
		super(SignInframe, txtUserName, txtPassword, txtId);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valid = true;
		valid = checkUserName(txtUserName.getText()) && valid;
		valid = checkPassword(txtPassword.getText()) && valid;
		valid = checkID(this.txtId.getText()) && valid;
		if(valid) {
			
		}
	}
}
