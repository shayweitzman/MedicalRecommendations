package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JTextField;
import javax.swing.border.Border;

import program.diagnose;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class MainFrame  {

	private String name;
	private JFrame frame;
	private JTextField nameField;
	private JTextField IdField;
	private JTextField WBCField;
	private JTextField neutField;
	private JTextField lymphField;
	private JTextField UreaField;
	private JTextField RBCField;
	private JTextField hbField;
	private JTextField creatinieField;
	private JTextField ironField;
	private JTextField HDLField;
	private JTextField APField;
	private JTextField ageField;

	/**
	 * Create the application.
	 */
	public MainFrame(String userName)  {
		this.name = userName;
		initialize();
	}
	
	public static void visible(MainFrame user) {
		user.cleanPage();
	}
	
	public void cleanPage() {
		this.nameField.setText("");
		IdField.setText("");
		WBCField.setText("");
		neutField.setText("");
		lymphField.setText("");
		UreaField.setText("");
		RBCField.setText("");
		hbField.setText("");
		creatinieField.setText("");
		ironField.setText("");
		HDLField.setText("");
		APField.setText("");
		ageField.setText("");
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Path currentRelativePath = Paths.get("");
		frame = new JFrame();
		frame.setTitle("Patient's Details");
		ImageIcon icon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//icon.png");
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);

		ImageIcon logOut = new ImageIcon(
				currentRelativePath.toAbsolutePath().toString() + "//source//images//logOut.png");
		JButton logOutButton = new JButton(Wellcome.resizeIcon(logOut, 50, 50));
		logOutButton.setToolTipText("Log Out");
		logOutButton.setBackground(Color.white);
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		logOutButton.setBorder(emptyBorder);
		logOutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Wellcome.frame.setVisible(true);
			}
		});
		logOutButton.setBounds(609, 0, 50, 50);
		frame.getContentPane().add(logOutButton);

		JLabel docNameLabel = new JLabel("Hello " + this.name);
		docNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		docNameLabel.setBounds(0, 0, 220, 37);
		frame.getContentPane().add(docNameLabel);

		ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//forth.png");
		JLabel lblNewLabel = new JLabel(Wellcome.resizeIcon(img, 300, 300));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(193, -20, 300, 300);
		frame.getContentPane().add(lblNewLabel);

		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NameLabel.setBounds(21, 267, 82, 37);
		frame.getContentPane().add(NameLabel);

		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nameField.setBounds(98, 265, 135, 37);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);

		JLabel IdLabel = new JLabel("ID");
		IdLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IdLabel.setBounds(247, 267, 27, 37);
		frame.getContentPane().add(IdLabel);

		IdField = new JTextField();
		IdField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		IdField.setColumns(10);
		IdField.setBounds(284, 267, 160, 37);
		frame.getContentPane().add(IdField);

		JLabel ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ageLabel.setBounds(454, 267, 50, 37);
		frame.getContentPane().add(ageLabel);

		ageField = new JTextField();
		ageField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ageField.setColumns(10);
		ageField.setBounds(514, 265, 135, 37);
		frame.getContentPane().add(ageField);

		JLabel WBCLabel = new JLabel("WBC");
		WBCLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		WBCLabel.setBounds(21, 319, 82, 37);
		frame.getContentPane().add(WBCLabel);

		WBCField = new JTextField();
		WBCField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		WBCField.setColumns(10);
		WBCField.setBounds(98, 317, 135, 37);
		frame.getContentPane().add(WBCField);

		JLabel neutLabel = new JLabel("Neut");
		neutLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		neutLabel.setBounds(247, 319, 63, 37);
		frame.getContentPane().add(neutLabel);

		JLabel lymphLabel = new JLabel("Lymph");
		lymphLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lymphLabel.setBounds(21, 371, 82, 37);
		frame.getContentPane().add(lymphLabel);

		JLabel RBCLabel = new JLabel("RBC");
		RBCLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		RBCLabel.setBounds(247, 371, 55, 37);
		frame.getContentPane().add(RBCLabel);

		JLabel UreaLabel = new JLabel("Urea");
		UreaLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		UreaLabel.setBounds(454, 323, 82, 37);
		frame.getContentPane().add(UreaLabel);

		JLabel hbLabel = new JLabel("Hb");
		hbLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		hbLabel.setBounds(454, 371, 39, 37);
		frame.getContentPane().add(hbLabel);

		JLabel creatinieLabel = new JLabel("Creatinine");
		creatinieLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		creatinieLabel.setBounds(20, 419, 120, 37);
		frame.getContentPane().add(creatinieLabel);

		JLabel ironLabel = new JLabel("Iron");
		ironLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ironLabel.setBounds(247, 419, 50, 37);
		frame.getContentPane().add(ironLabel);

		JLabel hdlLabel = new JLabel("HDL");
		hdlLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		hdlLabel.setBounds(454, 421, 50, 37);
		frame.getContentPane().add(hdlLabel);

		JLabel APLabel = new JLabel("Alkaline Phosphatase");
		APLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		APLabel.setBounds(21, 489, 244, 37);
		frame.getContentPane().add(APLabel);

		neutField = new JTextField();
		neutField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		neutField.setColumns(10);
		neutField.setBounds(309, 319, 135, 37);
		frame.getContentPane().add(neutField);

		lymphField = new JTextField();
		lymphField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lymphField.setColumns(10);
		lymphField.setBounds(98, 369, 135, 37);
		frame.getContentPane().add(lymphField);

		UreaField = new JTextField();
		UreaField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UreaField.setColumns(10);
		UreaField.setBounds(514, 319, 135, 37);
		frame.getContentPane().add(UreaField);

		RBCField = new JTextField();
		RBCField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		RBCField.setColumns(10);
		RBCField.setBounds(309, 373, 135, 37);
		frame.getContentPane().add(RBCField);

		hbField = new JTextField();
		hbField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		hbField.setColumns(10);
		hbField.setBounds(514, 369, 135, 37);
		frame.getContentPane().add(hbField);

		creatinieField = new JTextField();
		creatinieField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		creatinieField.setColumns(10);
		creatinieField.setBounds(139, 419, 94, 37);
		frame.getContentPane().add(creatinieField);

		ironField = new JTextField();
		ironField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ironField.setColumns(10);
		ironField.setBounds(309, 421, 135, 37);
		frame.getContentPane().add(ironField);

		HDLField = new JTextField();
		HDLField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		HDLField.setColumns(10);
		HDLField.setBounds(514, 417, 135, 37);
		frame.getContentPane().add(HDLField);

		APField = new JTextField();
		APField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		APField.setColumns(10);
		APField.setBounds(263, 488, 120, 37);
		frame.getContentPane().add(APField);

		JButton diagnoseButton = new JButton("Diagnose");
		diagnoseButton.setForeground(Color.WHITE);

		diagnoseButton.addActionListener((ActionListener) new diagnose(this,frame, this.name,nameField, IdField, ageField, WBCField,
				neutField, lymphField, UreaField, RBCField, hbField, creatinieField, ironField, HDLField, APField));

		diagnoseButton.setBackground(new Color(64, 166, 234));
		diagnoseButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		diagnoseButton.setBounds(415, 481, 234, 86);
		frame.getContentPane().add(diagnoseButton);
		frame.setBounds(100, 100, 673, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
