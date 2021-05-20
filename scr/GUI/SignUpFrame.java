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
import program.SignUp;

public class SignUpFrame implements ActionListener {
	private JFrame frm;
	private JFrame SignUpframe;
	private JTextField txtUserName;
	private JTextField txtCPassword;
	private JTextField txtPassword;
	private JTextField txtId;
	
	public SignUpFrame(JFrame frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frm.setVisible(false);
		Path currentRelativePath = Paths.get("");
		SignUpframe = new JFrame();
		SignUpframe.setTitle("Sign Up");
		ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//icon.png");
		SignUpframe.setIconImage(img.getImage());
		SignUpframe.setBounds(100, 100, 780, 409);
		SignUpframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignUpframe.getContentPane().setBackground(Color.WHITE);
		SignUpframe.getContentPane().setLayout(null);
		SignUpframe.setVisible(true);
		
		//JLabel lblNewLabel = new JLabel("Log In");
		//Path currentRelativePath = Paths.get("");
		ImageIcon image = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//third.png");
		JLabel lblNewLabel = new JLabel(Wellcome.resizeIcon(image, 100,100));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(340, 0, 100, 100);
		SignUpframe.getContentPane().add(lblNewLabel);
		
		txtUserName = new JTextField("User Name");
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		//txtUserName.setText("User Name");
		txtUserName.setBounds(250, 113, 276, 35);
		SignUpframe.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField("Password");
		//txtPassword.setText();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.setColumns(10);
		txtPassword.setBounds(250, 153, 276, 35);
		SignUpframe.getContentPane().add(txtPassword);
		
		txtCPassword = new JTextField("Confirm Passowrd");
		txtCPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		//txtUserName.setText("User Name");
		txtCPassword.setBounds(250, 196, 276, 35);
		SignUpframe.getContentPane().add(txtCPassword);
		txtCPassword.setColumns(10);
		
		txtId = new JTextField("ID");
		//txtId.setText("ID");
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtId.setColumns(10);
		txtId.setBounds(250, 236, 276, 35);
		SignUpframe.getContentPane().add(txtId);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpframe.dispose();
				frm.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backButton.setBounds(50, 280, 231, 60);
		backButton.setBackground(new Color(64,166,234));
		backButton.setForeground(Color.white);
		SignUpframe.getContentPane().add(backButton);
		
		JButton SignUpButton = new JButton("Sign up");
		SignUpButton.addActionListener((ActionListener)new SignUp(SignUpframe, txtUserName, txtPassword, txtId, txtCPassword));
		SignUpButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		SignUpButton.setBounds(500, 280, 231, 60);
		SignUpButton.setBackground(new Color(64,166,234));
		SignUpButton.setForeground(Color.white);
		SignUpframe.getContentPane().add(SignUpButton);
		
	}

}
