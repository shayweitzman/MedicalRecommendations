package GUI;

import java.awt.EventQueue;
import java.awt.Desktop;
import java.io.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class DiagnoseFrame implements ActionListener {

	private JFrame frame;
	private String results;
	private String pID;
	private String docName;
	private String patientName;
	private MainFrame user;

	/**
	 * Create the application.
	 */
	public DiagnoseFrame(MainFrame user,String results, String pID, String docName, String patientName) {
		this.results = results;
		this.pID = pID;
		this.docName = docName;
		this.patientName = patientName;
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Path currentRelativePath = Paths.get("");
		frame = new JFrame();
		frame.setTitle("Patient's Diagnose");
		ImageIcon icon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//icon.png");
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		ImageIcon img = new ImageIcon(
				currentRelativePath.toAbsolutePath().toString() + "//source//images//fifth.png");

		JLabel lblNewLabel = new JLabel(Welcome.resizeIcon(img, 200, 200));

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(220, -10, 200, 200);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Hello " + this.docName);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(0, 0, 274, 50);
		frame.getContentPane().add(lblNewLabel_1);

		ImageIcon logOut = new ImageIcon(
				currentRelativePath.toAbsolutePath().toString() + "//source//images//logOut.png");
		JButton logOutButton = new JButton(Welcome.resizeIcon(logOut, 50, 50));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		logOutButton.setBorder(emptyBorder);
		logOutButton.setToolTipText("Log Out");
		logOutButton.setBackground(Color.white);
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		logOutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Welcome.frame.setVisible(true);
			}
		});
		logOutButton.setBounds(609, 0, 50, 50);
		frame.getContentPane().add(logOutButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainFrame.visible(user);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backButton.setBounds(60, 453, 237, 94);
		backButton.setBackground(new Color(64,166,234));
		backButton.setForeground(Color.white);
		frame.getContentPane().add(backButton);

		JButton PHistoryButton = new JButton("Patient History");
		PHistoryButton.setForeground(Color.WHITE);
		PHistoryButton.addActionListener(this);
		PHistoryButton.setBackground(new Color(64, 166, 234));
		PHistoryButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PHistoryButton.setBounds(372, 453, 237, 94);
		frame.getContentPane().add(PHistoryButton);

		JTextArea textArea = new JTextArea(this.results);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(24, 177, 585, 265);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBorder(BorderFactory.createLineBorder(Color.white));
		scroll.setBounds(24, 177, 585, 265);
		frame.getContentPane().add(scroll);

		frame.setBounds(100, 100, 673, 611);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Path currentRelativePath = Paths.get("");
		try {
			File file = new File(currentRelativePath.toAbsolutePath().toString() + "//source//Patients//" + pID + ".txt");
			if (!Desktop.isDesktopSupported()) {
				JOptionPane.showMessageDialog(frame, "This feature is not supported", "Warning", JOptionPane.DEFAULT_OPTION);
				return;
			}
			Desktop desktop = Desktop.getDesktop();
			if (file.exists()) // checks file exists or not
				desktop.open(file); // opens the specified file
		} catch (Exception ea) {
			ea.printStackTrace();
		}
	}

}
