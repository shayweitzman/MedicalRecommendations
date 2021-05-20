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
		ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//icon.png");
		SignUpframe.setIconImage(img.getImage());
		SignUpframe.setBounds(100, 100, 780, 409);
		SignUpframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignUpframe.getContentPane().setBackground(Color.WHITE);
		SignUpframe.getContentPane().setLayout(null);
		SignUpframe.setVisible(true);
		
		
		ImageIcon image = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//third.png");
		JLabel lblNewLabel = new JLabel(Wellcome.resizeIcon(image, 100,100));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(340, 0, 100, 100);
		SignUpframe.getContentPane().add(lblNewLabel);
		
		
		
		//
		ImageIcon usernameImage = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//Username.png");
		JLabel lblUsernameLabel = new JLabel(Wellcome.resizeIcon(usernameImage, 35,35));
		lblUsernameLabel.setBounds(120, 40, 180, 180);
		SignUpframe.getContentPane().add(lblUsernameLabel);
		
		ImageIcon passwordImage = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//password.png");
		JLabel lblPassLabel = new JLabel(Wellcome.resizeIcon(passwordImage, 45,45));
		lblPassLabel.setBounds(110, 70, 200, 200);
		SignUpframe.getContentPane().add(lblPassLabel);

		ImageIcon cPasswordImage = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//confirmpassword.png");
		JLabel lblCPassLabel = new JLabel(Wellcome.resizeIcon(cPasswordImage, 55,55));
		lblCPassLabel.setBounds(115, 105, 200, 200);
		SignUpframe.getContentPane().add(lblCPassLabel);
		
		ImageIcon idImage = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//ID.png");
		JLabel lblIDLabel = new JLabel(Wellcome.resizeIcon(idImage, 45,45));
		lblIDLabel.setBounds(110, 150, 200, 200);
		SignUpframe.getContentPane().add(lblIDLabel);	
		
		
		
		//
		
		
		
		
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
