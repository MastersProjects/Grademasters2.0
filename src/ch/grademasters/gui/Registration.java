package ch.grademasters.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import ch.grademasters.actionlistener.LoginListener;
import ch.grademasters.actionlistener.RegisterListener;
import ch.grademasters.utils.MD5;

public class Registration extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//InputField
	private JTextField inp_email;
	private JTextField inp_username;
	private JTextField inp_lastname;
	private JTextField inp_firstname;
	private JPasswordField inp_password2;
	private JPasswordField inp_password1;
	
	//Label
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblTitel;
	private JLabel lblVorname; 
	private JLabel lblNachname;
	private JLabel lblPasswort2;
	private JLabel lblPasswort;
	
	//Panel
	private JPanel panel_buttons;
	private JPanel panel_form;
	private JPanel contentPane;
	
	private SpringLayout form_springLayout;
	
	//Button
	private JButton btnAbbrechen;
	private JButton btnRegistrieren;
	
	private ActionListener actionListener;

	public Registration() {
		//Jpanel Settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 266);
		setLocationRelativeTo(null);
		
		//Set Panels
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Panel for Buttons
		panel_buttons = new JPanel();
		contentPane.add(panel_buttons, BorderLayout.SOUTH);
		panel_buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Panel for form
		panel_form = new JPanel();
		contentPane.add(panel_form, BorderLayout.CENTER);
		form_springLayout = new SpringLayout();
		panel_form.setLayout(form_springLayout);
		
		//Set Labels
		lblTitel = new JLabel("GradeMasters Registration");
		lblTitel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername = new JLabel("Username");
		lblEmail = new JLabel("Email");
		lblVorname = new JLabel("Vorname");
		lblNachname = new JLabel("Nachname");
		lblPasswort = new JLabel("Passwort");
		lblPasswort2 = new JLabel("Passwort");
		form_springLayout.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblUsername);
		
		//Set Buttons
		btnAbbrechen = new JButton("Abbrechen");
		btnRegistrieren = new JButton("Registrieren");
		
		//ActionListener
		actionListener = new RegisterListener(this);
		btnAbbrechen.addActionListener(actionListener);
		btnRegistrieren.addActionListener(actionListener);

		//Set Textfields
		inp_email = new JTextField();
		form_springLayout.putConstraint(SpringLayout.NORTH, inp_email, 0, SpringLayout.NORTH, lblEmail);
		form_springLayout.putConstraint(SpringLayout.EAST, inp_email, -43, SpringLayout.EAST, panel_form);
		inp_email.setColumns(10);
		
		//Add Buttons to panel_buttons
		panel_buttons.add(btnAbbrechen);
		panel_buttons.add(btnRegistrieren);
		
		//Add Labels and Textfields to form
		form_springLayout.putConstraint(SpringLayout.NORTH, lblUsername, 30, SpringLayout.NORTH, panel_form);
		form_springLayout.putConstraint(SpringLayout.WEST, lblUsername, 22, SpringLayout.WEST, panel_form);
		panel_form.add(lblUsername);
		panel_form.add(inp_email);
		inp_email.setColumns(10);
		panel_form.add(lblEmail);
		
		inp_username = new JTextField();
		form_springLayout.putConstraint(SpringLayout.WEST, inp_username, 27, SpringLayout.EAST, lblUsername);
		form_springLayout.putConstraint(SpringLayout.EAST, inp_username, -43, SpringLayout.EAST, panel_form);
		form_springLayout.putConstraint(SpringLayout.WEST, inp_email, 0, SpringLayout.WEST, inp_username);
		form_springLayout.putConstraint(SpringLayout.NORTH, inp_username, -6, SpringLayout.NORTH, lblUsername);
		panel_form.add(inp_username);
		inp_username.setColumns(10);
		
		form_springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 14, SpringLayout.SOUTH, lblVorname);
		form_springLayout.putConstraint(SpringLayout.NORTH, lblVorname, 15, SpringLayout.SOUTH, lblUsername);
		form_springLayout.putConstraint(SpringLayout.WEST, lblVorname, 0, SpringLayout.WEST, lblUsername);
		panel_form.add(lblVorname);
		
		form_springLayout.putConstraint(SpringLayout.NORTH, lblNachname, 0, SpringLayout.NORTH, lblVorname);
		panel_form.add(lblNachname);
		
		inp_lastname = new JTextField();
		form_springLayout.putConstraint(SpringLayout.NORTH, inp_lastname, -6, SpringLayout.NORTH, lblVorname);
		form_springLayout.putConstraint(SpringLayout.WEST, inp_lastname, 6, SpringLayout.EAST, lblNachname);
		form_springLayout.putConstraint(SpringLayout.EAST, inp_lastname, -43, SpringLayout.EAST, panel_form);
		inp_lastname.setColumns(10);
		panel_form.add(inp_lastname);
		
		inp_firstname = new JTextField();
		form_springLayout.putConstraint(SpringLayout.WEST, lblNachname, 6, SpringLayout.EAST, inp_firstname);
		form_springLayout.putConstraint(SpringLayout.WEST, inp_firstname, 34, SpringLayout.EAST, lblVorname);
		form_springLayout.putConstraint(SpringLayout.EAST, inp_firstname, -213, SpringLayout.EAST, panel_form);
		form_springLayout.putConstraint(SpringLayout.NORTH, inp_firstname, -6, SpringLayout.NORTH, lblVorname);
		inp_firstname.setColumns(10);
		panel_form.add(inp_firstname);
		
		form_springLayout.putConstraint(SpringLayout.NORTH, lblPasswort, 18, SpringLayout.SOUTH, lblEmail);
		form_springLayout.putConstraint(SpringLayout.WEST, lblPasswort, 0, SpringLayout.WEST, lblUsername);
		panel_form.add(lblPasswort);
		
		inp_password2 = new JPasswordField();
		form_springLayout.putConstraint(SpringLayout.NORTH, inp_password2, -6, SpringLayout.NORTH, lblPasswort);
		form_springLayout.putConstraint(SpringLayout.WEST, inp_password2, 0, SpringLayout.WEST, inp_lastname);
		form_springLayout.putConstraint(SpringLayout.EAST, inp_password2, 92, SpringLayout.WEST, inp_lastname);
		inp_password2.setColumns(10);
		panel_form.add(inp_password2);
		
		form_springLayout.putConstraint(SpringLayout.NORTH, lblPasswort2, 6, SpringLayout.SOUTH, inp_email);
		form_springLayout.putConstraint(SpringLayout.WEST, lblPasswort2, 0, SpringLayout.WEST, lblNachname);
		panel_form.add(lblPasswort2);
		
		inp_password1 = new JPasswordField();
		form_springLayout.putConstraint(SpringLayout.NORTH, inp_password1, -6, SpringLayout.NORTH, lblPasswort);
		form_springLayout.putConstraint(SpringLayout.WEST, inp_password1, 34, SpringLayout.EAST, lblPasswort);
		form_springLayout.putConstraint(SpringLayout.EAST, inp_password1, -6, SpringLayout.WEST, lblPasswort2);
		inp_password1.setColumns(10);
		panel_form.add(inp_password1);
				
		//Add title to contentPane
		contentPane.add(lblTitel, BorderLayout.NORTH);
		
		setVisible(true);
	}

	public String getInp_email() {
		return inp_email.getText();
	}

	public String getInp_username() {
		return inp_username.getText();
	}

	public String getInp_lastname() {
		return inp_lastname.getText();
	}

	public String getInp_firstname() {
		return inp_firstname.getText();
	}

	public String getInp_password1() {
		MD5 md5decoder = new MD5();
		return md5decoder.getMD5(inp_password1.getText());
	}

	public String getInp_password2() {
		MD5 md5decoder = new MD5();
		return md5decoder.getMD5(inp_password2.getText());
	}
}
