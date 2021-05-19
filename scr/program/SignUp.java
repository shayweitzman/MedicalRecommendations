package program;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignUp extends Form implements ActionListener {
	private JTextField txtCPassword;
	
	public SignUp(JFrame SignInframe, JTextField txtUserName, JTextField txtPassword, JTextField txtId, JTextField txtCPassword) {
		super(SignInframe, txtUserName, txtPassword, txtId);
		this.txtCPassword = txtCPassword;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valid = true;
		valid = checkUserName(txtUserName.getText()) && valid;
		valid = checkPassword(txtPassword.getText()) && valid;
		valid = checkConfirmPassword(txtPassword.getText(), txtCPassword.getText()) && valid;
		valid = checkID(this.txtId.getText()) && valid;
		if(valid) {
			
		}
			
		
	}
	
	private boolean checkConfirmPassword(String password, String ConfPassword) {
		if(!password.equals(ConfPassword)) {
			JOptionPane.showMessageDialog(SignUpframe, "the password are not match","Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

}
