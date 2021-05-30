package program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.Database;
import GUI.MainFrame;

public class LogIn extends Form implements ActionListener {
	public LogIn() {
	};

	public LogIn(JFrame SignInframe, JTextField txtUserName, JTextField txtPassword, JTextField txtId) {
		super(SignInframe, txtUserName, txtPassword, txtId);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean valid = true;
		valid = checkUserName(txtUserName.getText()) && valid;
		valid = checkPassword(txtPassword.getText()) && valid;
		valid = checkID(this.txtId.getText()) && valid;
		if (valid) {
			Database db = new Database(txtUserName.getText(), txtPassword.getText(), this.txtId.getText());
			String msg = db.isUserExist();
			if (msg == "Login Success") {
				this.SignUpframe.dispose();
				MainFrame main = new MainFrame(txtUserName.getText());
			} else {
				JOptionPane.showMessageDialog(SignUpframe, msg, "Warning", JOptionPane.WARNING_MESSAGE);
			}

		}
	}
}
