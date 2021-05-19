package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.getContentPane().setBackground(new Color(1,214,218));
		frame.setBounds(100, 100, 780, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton SignInButton = new JButton("Sign In");
		SignInButton.setBackground(Color.LIGHT_GRAY);
		SignInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		SignInButton.setBounds(50, 266, 302, 83);
		frame.getContentPane().add(SignInButton);
		
		JButton LogInButton = new JButton("Log In");
		LogInButton.addActionListener((ActionListener)new LogInFrame(frame));
		LogInButton.setBackground(Color.LIGHT_GRAY);
		LogInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LogInButton.setBounds(421, 266, 302, 83);
		frame.getContentPane().add(LogInButton);
		
		JLabel lblNewLabel = new JLabel("Wellcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(264, 126, 218, 61);
		frame.getContentPane().add(lblNewLabel);
	}

}
