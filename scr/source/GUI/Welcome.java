package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Welcome {

	public static JFrame frame;
	public static Path currentRelativePath = Paths.get("");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MainFrame x = new MainFrame("aln");
					//DiagnoseFrame y = new DiagnoseFrame(x,"dsf","dsf","fds","gfd");
					Welcome window = new Welcome();
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
	public Welcome() {
		initialize();
		
	}
	
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Medical Recommendation");
		ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1070, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JLabel lblNewLabel = new JLabel("New label");
		
		ImageIcon image = new ImageIcon(
				currentRelativePath.toAbsolutePath().toString() + "//source//images//Welcome.png");
		JLabel backgroundLabel = new JLabel(image);
		backgroundLabel.setBounds(0, -10, 1070, 543);
		
		
		JButton SignInButton = new JButton("Sign Up");
		SignInButton.addActionListener((ActionListener) new Sign_UpFrame(frame));
		SignInButton.setBackground(new Color(64, 166, 234));
		SignInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		SignInButton.setForeground(Color.white);
		SignInButton.setBounds(827, 279, 160, 64);
		frame.getContentPane().add(SignInButton);
		
		JButton LogInButton = new JButton("Login");
		LogInButton.addActionListener((ActionListener) new Log_InFrame(frame));
		LogInButton.setBackground(new Color(64, 166, 234));
		LogInButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LogInButton.setForeground(Color.white);
		LogInButton.setBounds(638, 279, 160, 64);
		frame.getContentPane().add(LogInButton);
		frame.getContentPane().add(backgroundLabel);
	}
}
