package program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.Database;
import GUI.Wellcome;

public class SignUp extends Form implements ActionListener {
	private JTextField txtCPassword;


	public SignUp(JFrame SignUpframe,JTextField txtUserName, JTextField txtPassword, JTextField txtId,
			JTextField txtCPassword) {
		super(SignUpframe, txtUserName, txtPassword, txtId);
		this.txtCPassword = txtCPassword;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valid = true;
		valid = checkUserName(txtUserName.getText()) && valid;
		valid = checkPassword(txtPassword.getText()) && valid;
		valid = checkConfirmPassword(txtPassword.getText(), txtCPassword.getText()) && valid;
		valid = checkID(this.txtId.getText()) && valid;
		if (valid) {
			Database db = new Database(txtUserName.getText(), txtPassword.getText(), this.txtId.getText());
			String msg = db.Write();

			if (msg.equals("Signed Up Successfully")) {
				SignUpframe.dispose();
				Wellcome.frame.setVisible(true);
				JOptionPane.showMessageDialog(SignUpframe, msg, "Success", JOptionPane.DEFAULT_OPTION);

			} else {
				JOptionPane.showMessageDialog(SignUpframe, msg, "Warning", JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	private boolean checkConfirmPassword(String password, String ConfPassword) {
		if (!password.equals(ConfPassword)) {
			JOptionPane.showMessageDialog(SignUpframe, "the password are not match", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

}
