package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import program.LogIn;

public class LogInFrame implements ActionListener {
	private JFrame frm;
	private JFrame SignInframe;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtId;
	
	public LogInFrame(JFrame frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frm.setVisible(false);
		SignInframe = new JFrame();
		SignInframe.setBounds(100, 100, 780, 409);
		SignInframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignInframe.getContentPane().setLayout(null);
		SignInframe.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(290, 11, 157, 81);
		SignInframe.getContentPane().add(lblNewLabel);
		
		txtUserName = new JTextField("User Name",8);
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		//txtUserName.setText("User Name");
		txtUserName.setBounds(250, 103, 276, 40);
		SignInframe.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField("Password",10);
		//txtPassword.setText();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.setColumns(10);
		txtPassword.setBounds(250, 153, 276, 40);
		SignInframe.getContentPane().add(txtPassword);
		
		txtId = new JTextField("ID");
		//txtId.setText("ID");
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtId.setColumns(10);
		txtId.setBounds(250, 206, 276, 40);
		SignInframe.getContentPane().add(txtId);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SignInframe.dispose();
				frm.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backButton.setBounds(50, 280, 231, 60);
		backButton.setBackground(Color.LIGHT_GRAY);
		SignInframe.getContentPane().add(backButton);
		
		JButton logInButton = new JButton("login");
		logInButton.addActionListener((ActionListener)new LogIn(SignInframe, txtUserName, txtPassword, txtId));
		logInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		logInButton.setBounds(500, 280, 231, 60);
		logInButton.setBackground(Color.LIGHT_GRAY);
		SignInframe.getContentPane().add(logInButton);
		
	}

}
