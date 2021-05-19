package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
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
		Path currentRelativePath = Paths.get("");
		SignInframe = new JFrame();
		ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//icon.png");
		SignInframe.setIconImage(img.getImage());
		SignInframe.setBounds(100, 100, 780, 409);
		SignInframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignInframe.getContentPane().setBackground(Color.WHITE);
		SignInframe.getContentPane().setLayout(null);
		SignInframe.setVisible(true);
		
		//JLabel lblNewLabel = new JLabel("Log In");
		//Path currentRelativePath = Paths.get("");
		ImageIcon image = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//sec.png");
		JLabel lblNewLabel = new JLabel(Wellcome.resizeIcon(image, 200,200));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(280, -20, 200, 200);
		SignInframe.getContentPane().add(lblNewLabel);
		
		txtUserName = new JTextField("User Name",8);
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		//txtUserName.setText("User Name");
		txtUserName.setBounds(250, 153, 276, 35);
		SignInframe.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField("Password",10);
		//txtPassword.setText();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.setColumns(10);
		txtPassword.setBounds(250, 193, 276, 35);
		SignInframe.getContentPane().add(txtPassword);
		
		txtId = new JTextField("ID");
		//txtId.setText("ID");
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtId.setColumns(10);
		txtId.setBounds(250, 236, 276, 35);
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
		backButton.setBackground(new Color(64,166,234));
		backButton.setForeground(Color.white);
		SignInframe.getContentPane().add(backButton);
		
		JButton logInButton = new JButton("login");
		logInButton.addActionListener((ActionListener)new LogIn(SignInframe, txtUserName, txtPassword, txtId));
		logInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		logInButton.setBounds(500, 280, 231, 60);
		logInButton.setBackground(new Color(64,166,234));
		logInButton.setForeground(Color.white);
		SignInframe.getContentPane().add(logInButton);
		
	}

}