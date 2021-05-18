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
		checkID(this.txtId.getText());
		
		
		
		
	}
	
	private void checkUserName(String userName) {
		if(userName.length() < 6 || userName.length() > 10)
			JOptionPane.showMessageDialog(SignInframe, "User name must be between 6 and 10 characters","Warning", JOptionPane.WARNING_MESSAGE);
//		else if(userName.) {
//			
//		}
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

}
