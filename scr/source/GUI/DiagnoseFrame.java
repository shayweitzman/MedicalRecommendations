package GUI;

import java.awt.EventQueue;
import java.awt.Desktop;
import java.io.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class DiagnoseFrame implements ActionListener {

	private JFrame frame;
	private String results;
	private String pID;

	/**
	 * Create the application.
	 */
	public DiagnoseFrame(String results, String pID) {
		this.results = results;
		this.pID = pID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Path currentRelativePath = Paths.get("");
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("image");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(176, 0, 249, 204);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Hello");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(0, 0, 195, 50);
		frame.getContentPane().add(lblNewLabel_1);

		ImageIcon logOut = new ImageIcon(
				currentRelativePath.toAbsolutePath().toString() + "//source//images//logOut.png");
		JButton logOutButton = new JButton(Wellcome.resizeIcon(logOut, 50, 50));
		logOutButton.setToolTipText("Log Out");
		logOutButton.setBackground(Color.white);
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		logOutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Wellcome.frame.setVisible(true);
			}
		});
		logOutButton.setBounds(609, 0, 50, 50);
		frame.getContentPane().add(logOutButton);

		JButton PHistoryButton = new JButton("Patient History");
		PHistoryButton.setForeground(Color.WHITE);
		PHistoryButton.addActionListener(this);
		PHistoryButton.setBackground(new Color(64, 166, 234));
		PHistoryButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		PHistoryButton.setBounds(221, 499, 237, 64);
		frame.getContentPane().add(PHistoryButton);

		JTextArea textArea = new JTextArea(this.results);
		textArea.setBounds(24, 177, 585, 265);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
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
				System.out.println("not supported");
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
