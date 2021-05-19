package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Color;
import javax.swing.JLabel;

//import program.*;

public class Wellcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wellcome window = new Wellcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Wellcome() {
		initialize();
	}
	
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Path currentRelativePath = Paths.get("");
		frame = new JFrame();
		ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 780, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton SignInButton = new JButton("Sign Up");
		SignInButton.addActionListener((ActionListener)new SignUpFrame(frame));
		SignInButton.setBackground(new Color(64,166,234));
		SignInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		SignInButton.setForeground(Color.white);
		SignInButton.setBounds(50, 266, 302, 83);
		frame.getContentPane().add(SignInButton);
		
		JButton LogInButton = new JButton("Log In");
		LogInButton.addActionListener((ActionListener)new LogInFrame(frame));
		LogInButton.setBackground(new Color(64,166,234));
		LogInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LogInButton.setForeground(Color.white);
		LogInButton.setBounds(421, 266, 302, 83);
		frame.getContentPane().add(LogInButton);
		
		
		ImageIcon image = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//first (1).png");
		JLabel imagelabel = new JLabel(resizeIcon(image, 300,300));
		//Image resizedImage = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); 
		imagelabel.setBounds(234, -10, 300, 300);
		frame.add(imagelabel);
		
//		JLabel lblNewLabel = new JLabel("Wellcome");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
//		lblNewLabel.setBounds(264, 126, 218, 61);
//		frame.getContentPane().add(lblNewLabel);
	}

}