package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import program.diagnose;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSlider;

public class MainFrame  {

	private String name;
	private JFrame frame;
	private JTextField nameField;
	private JTextField IdField;
	private JTextField WBCField;
	private JTextField UreaField;
	private JTextField RBCField;
	private JTextField hbField;
	private JTextField creatinieField;
	private JTextField ironField;
	private JTextField HDLField;
	private JTextField APField;
	private JTextField ageField;
	private JSlider neutSlider;
	private JSlider lymphSlider;

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
		neutSlider.setValue(50);
		lymphSlider.setValue(50);
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
		frame.setResizable(false);
		frame.setTitle("Patient's Details");
		ImageIcon icon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//icon.png");
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);
		
		ImageIcon image = new ImageIcon(
				Welcome.currentRelativePath.toAbsolutePath().toString() + "//source//images//detailes.png");
		JLabel backgroundLabel = new JLabel(image);
		backgroundLabel.setBounds(0, 0, 1070, 859);

		ImageIcon logOut = new ImageIcon(
				currentRelativePath.toAbsolutePath().toString() + "//source//images//logOut.png");
		JButton logOutButton = new JButton(logOut);
		logOutButton.setToolTipText("Log Out");
		logOutButton.setBackground(new Color(64, 166, 234));
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		logOutButton.setBorder(emptyBorder);
		logOutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Welcome.frame.setVisible(true);
			}
		});
		logOutButton.setBounds(896, 20, 154, 57);
		frame.getContentPane().add(logOutButton);

		JLabel docNameLabel = new JLabel("Hello " + this.name);
		docNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		docNameLabel.setBounds(0, 0, 297, 37);
		frame.getContentPane().add(docNameLabel);

		ImageIcon img = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "//source//images//forth.png");

		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NameLabel.setBounds(45, 299, 82, 37);
		frame.getContentPane().add(NameLabel);

		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nameField.setBounds(163, 297, 198, 37);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);

		JLabel IdLabel = new JLabel("ID");
		IdLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		IdLabel.setBounds(400, 299, 27, 37);
		frame.getContentPane().add(IdLabel);

		IdField = new JTextField();
		IdField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		IdField.addKeyListener(new KeyAdapter() {
		        @Override
		        public void keyTyped(KeyEvent e) {
		            if (IdField.getText().length() >= 9 ) // limit to 9 characters
		                e.consume();
		        }
		    });
		IdField.setBounds(462, 297, 197, 37);
		frame.getContentPane().add(IdField);

		JLabel ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ageLabel.setBounds(702, 301, 50, 37);
		frame.getContentPane().add(ageLabel);

		ageField = new JTextField();
		ageField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ageField.setColumns(10);
		ageField.setBounds(762, 299, 254, 37);
		frame.getContentPane().add(ageField);

		JLabel WBCLabel = new JLabel("WBC");
		WBCLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		WBCLabel.setBounds(45, 349, 82, 37);
		frame.getContentPane().add(WBCLabel);

		WBCField = new JTextField();
		WBCField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		WBCField.setColumns(10);
		WBCField.setBounds(163, 347, 198, 37);
		frame.getContentPane().add(WBCField);

		JLabel neutLabel = new JLabel("Neut");
		neutLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		neutLabel.setBounds(568, 578, 63, 37);
		frame.getContentPane().add(neutLabel);

		JLabel lymphLabel = new JLabel("Lymph");
		lymphLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lymphLabel.setBounds(45, 578, 82, 37);
		frame.getContentPane().add(lymphLabel);

		JLabel RBCLabel = new JLabel("RBC");
		RBCLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		RBCLabel.setBounds(400, 349, 55, 37);
		frame.getContentPane().add(RBCLabel);

		JLabel UreaLabel = new JLabel("Urea");
		UreaLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		UreaLabel.setBounds(702, 355, 82, 37);
		frame.getContentPane().add(UreaLabel);

		JLabel hbLabel = new JLabel("Hb");
		hbLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		hbLabel.setBounds(702, 405, 39, 37);
		frame.getContentPane().add(hbLabel);

		JLabel creatinieLabel = new JLabel("Creatinine");
		creatinieLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		creatinieLabel.setBounds(163, 500, 120, 37);
		frame.getContentPane().add(creatinieLabel);

		JLabel ironLabel = new JLabel("Iron");
		ironLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ironLabel.setBounds(45, 397, 50, 37);
		frame.getContentPane().add(ironLabel);

		JLabel hdlLabel = new JLabel("HDL");
		hdlLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		hdlLabel.setBounds(400, 401, 50, 37);
		frame.getContentPane().add(hdlLabel);

		JLabel APLabel = new JLabel("Alkaline Phosphatase");
		APLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		APLabel.setBounds(525, 500, 244, 37);
		frame.getContentPane().add(APLabel);

		UreaField = new JTextField();
		UreaField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		UreaField.setColumns(10);
		UreaField.setBounds(762, 351, 254, 37);
		frame.getContentPane().add(UreaField);

		RBCField = new JTextField();
		RBCField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		RBCField.setColumns(10);
		RBCField.setBounds(462, 351, 197, 37);
		frame.getContentPane().add(RBCField);

		hbField = new JTextField();
		hbField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		hbField.setColumns(10);
		hbField.setBounds(762, 403, 254, 37);
		frame.getContentPane().add(hbField);

		creatinieField = new JTextField();
		creatinieField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		creatinieField.setColumns(10);
		creatinieField.setBounds(282, 500, 198, 37);
		frame.getContentPane().add(creatinieField);

		ironField = new JTextField();
		ironField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ironField.setColumns(10);
		ironField.setBounds(164, 395, 197, 37);
		frame.getContentPane().add(ironField);

		HDLField = new JTextField();
		HDLField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		HDLField.setColumns(10);
		HDLField.setBounds(460, 397, 199, 37);
		frame.getContentPane().add(HDLField);

		APField = new JTextField();
		APField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		APField.setColumns(10);
		APField.setBounds(767, 499, 198, 37);
		frame.getContentPane().add(APField);

		
		lymphSlider = new JSlider();
		lymphSlider.setBounds(129, 589, 281, 26);
		frame.getContentPane().add(lymphSlider);
		
		neutSlider = new JSlider();
		neutSlider.setBounds(633, 589, 312, 26);
		frame.getContentPane().add(neutSlider);
		frame.setBounds(100, 100, 1070, 859);
		
		JLabel lymphLabel_1 = new JLabel("50%");
		lymphLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lymphLabel_1.setBounds(420, 578, 82, 37);
		frame.getContentPane().add(lymphLabel_1);
		
		JLabel neutLabel_1 = new JLabel("50%");
		neutLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		neutLabel_1.setBounds(953, 578, 74, 37);
		frame.getContentPane().add(neutLabel_1);
		
		lymphSlider.addChangeListener(new ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               lymphLabel_1.setText("" + source.getValue() + "%");
            }
         });
		
		neutSlider.addChangeListener(new ChangeListener()
        {
           public void stateChanged(ChangeEvent event)
           {
              // update text field when the slider value changes
              JSlider source = (JSlider) event.getSource();
              neutLabel_1.setText("" + source.getValue() + "%");
           }
        });
		
		JButton diagnoseButton = new JButton("Diagnose");
		diagnoseButton.setBackground(Color.WHITE);
		diagnoseButton.setForeground(new Color(64, 166, 234));
		diagnoseButton.addActionListener((ActionListener) new diagnose(this,frame, this.name,nameField, IdField, ageField, WBCField,
				neutSlider, lymphSlider, UreaField, RBCField, hbField, creatinieField, ironField, HDLField, APField));
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		diagnoseButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		diagnoseButton.setBounds(793, 695, 234, 86);
		frame.getContentPane().add(diagnoseButton);
		frame.getContentPane().add(backgroundLabel);
		
		
	}

	
}
