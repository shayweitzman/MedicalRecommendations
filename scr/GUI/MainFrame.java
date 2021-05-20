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
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class MainFrame {

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


	/**
	 * Create the application.
	 */
	public MainFrame(String userName) {
		this.name = userName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Path currentRelativePath = Paths.get("");
		frame = new JFrame();
		frame.setTitle("Patient Details");
		ImageIcon icon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//icon.png");
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);
		
		ImageIcon logOut = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//logOut.png");
		JButton logOutButton = new JButton(Wellcome.resizeIcon(logOut, 50,50));
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
		logOutButton.setBounds(574, 0, 50, 50);
		frame.getContentPane().add(logOutButton);
		
		JLabel docNameLabel = new JLabel("Hello " + this.name);
		docNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		docNameLabel.setBounds(0, 0, 180, 37);
		frame.getContentPane().add(docNameLabel);
		
		ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//images//forth.png");
		JLabel lblNewLabel = new JLabel(Wellcome.resizeIcon(img, 256,256));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(190, -20, 256, 256);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NameLabel.setBounds(21, 210, 82, 37);
		frame.getContentPane().add(NameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nameField.setBounds(98, 211, 175, 31);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel IdLabel = new JLabel("ID");
		IdLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IdLabel.setBounds(21, 258, 82, 31);
		frame.getContentPane().add(IdLabel);
		
		JCheckBox chckbxAfrica = new JCheckBox("North Africa Roots");
		chckbxAfrica.setBackground(Color.WHITE);
		chckbxAfrica.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxAfrica.setBounds(332, 199, 267, 37);
		frame.getContentPane().add(chckbxAfrica);
		
		JCheckBox chckbxPregnant = new JCheckBox("Pregnant");
		chckbxPregnant.setBackground(Color.WHITE);
		chckbxPregnant.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxPregnant.setBounds(332, 239, 267, 37);
		frame.getContentPane().add(chckbxPregnant);
		
		JCheckBox chckbxEthiopian = new JCheckBox("Ethiopian Roots");
		chckbxEthiopian.setBackground(Color.WHITE);
		chckbxEthiopian.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chckbxEthiopian.setBounds(332, 276, 267, 37);
		frame.getContentPane().add(chckbxEthiopian);
		
		JLabel WBCLabel = new JLabel("WBC");
		WBCLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		WBCLabel.setBounds(21, 337, 63, 37);
		frame.getContentPane().add(WBCLabel);
		
		IdField = new JTextField();
		IdField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		IdField.setColumns(10);
		IdField.setBounds(98, 258, 175, 31);
		frame.getContentPane().add(IdField);
		
		WBCField = new JTextField();
		WBCField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		WBCField.setColumns(10);
		WBCField.setBounds(87, 338, 98, 31);
		frame.getContentPane().add(WBCField);
		
		JLabel neutLabel = new JLabel("Neut");
		neutLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		neutLabel.setBounds(193, 337, 63, 37);
		frame.getContentPane().add(neutLabel);
		
		JLabel lymphLabel = new JLabel("Lymph");
		lymphLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lymphLabel.setBounds(390, 337, 78, 37);
		frame.getContentPane().add(lymphLabel);
		
		JLabel RBCLabel = new JLabel("RBC");
		RBCLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		RBCLabel.setBounds(195, 385, 78, 37);
		frame.getContentPane().add(RBCLabel);
		
		JLabel UreaLabel = new JLabel("Urea");
		UreaLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		UreaLabel.setBounds(21, 385, 78, 37);
		frame.getContentPane().add(UreaLabel);
		
		JLabel hbLabel = new JLabel("Hb");
		hbLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		hbLabel.setBounds(415, 385, 53, 37);
		frame.getContentPane().add(hbLabel);
		
		JLabel creatinieLabel = new JLabel("Creatinine");
		creatinieLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		creatinieLabel.setBounds(21, 433, 120, 37);
		frame.getContentPane().add(creatinieLabel);
		
		JLabel ironLabel = new JLabel("Iron");
		ironLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ironLabel.setBounds(253, 433, 63, 37);
		frame.getContentPane().add(ironLabel);
		
		JLabel hdlLabel = new JLabel("HDL");
		hdlLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		hdlLabel.setBounds(415, 440, 63, 32);
		frame.getContentPane().add(hdlLabel);
		
		JLabel APLabel = new JLabel("Alkaline Phosphatase");
		APLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		APLabel.setBounds(21, 487, 244, 32);
		frame.getContentPane().add(APLabel);
		
		neutField = new JTextField();
		neutField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		neutField.setColumns(10);
		neutField.setBounds(253, 338, 98, 31);
		frame.getContentPane().add(neutField);
		
		lymphField = new JTextField();
		lymphField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lymphField.setColumns(10);
		lymphField.setBounds(466, 338, 98, 31);
		frame.getContentPane().add(lymphField);
		
		UreaField = new JTextField();
		UreaField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UreaField.setColumns(10);
		UreaField.setBounds(87, 391, 98, 31);
		frame.getContentPane().add(UreaField);
		
		RBCField = new JTextField();
		RBCField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		RBCField.setColumns(10);
		RBCField.setBounds(253, 386, 98, 31);
		frame.getContentPane().add(RBCField);
		
		hbField = new JTextField();
		hbField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		hbField.setColumns(10);
		hbField.setBounds(466, 386, 98, 31);
		frame.getContentPane().add(hbField);
		
		creatinieField = new JTextField();
		creatinieField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		creatinieField.setColumns(10);
		creatinieField.setBounds(139, 439, 98, 31);
		frame.getContentPane().add(creatinieField);
		
		ironField = new JTextField();
		ironField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ironField.setColumns(10);
		ironField.setBounds(307, 439, 98, 31);
		frame.getContentPane().add(ironField);
		
		HDLField = new JTextField();
		HDLField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		HDLField.setColumns(10);
		HDLField.setBounds(466, 439, 98, 31);
		frame.getContentPane().add(HDLField);
		
		APField = new JTextField();
		APField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		APField.setColumns(10);
		APField.setBounds(263, 488, 120, 31);
		frame.getContentPane().add(APField);
		
		JButton diagnoseButton = new JButton("diagnose");
		diagnoseButton.setBackground(new Color(64,166,234));
		diagnoseButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		diagnoseButton.setBounds(415, 481, 199, 86);
		frame.getContentPane().add(diagnoseButton);
		frame.setBounds(100, 100, 638, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
