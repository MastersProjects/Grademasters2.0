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
import ch.grademasters.utils.MD5;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//InputField
	private JTextField inp_username;
	private JPasswordField inp_password;
	
	//Label
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblTitel;
	
	//Panel
	private JPanel panel_buttons;
	private JPanel panel_form;
	private JPanel contentPane;
	
	private SpringLayout form_springLayout;
	
	//Button
	private JButton btnAbbrechen;
	private JButton btnRegistrieren;
	private JButton btnLogin;
	
	private ActionListener actionListener;

	public Login() {
		//Jpanel Settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 225);
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
		lblTitel = new JLabel("GradeMasters Login");
		lblTitel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Passwort");
		
		//Set Buttons
		btnAbbrechen = new JButton("Abbrechen");
		btnRegistrieren = new JButton("Registrieren");
		btnLogin = new JButton("Login");
		
		//ActionListener
		actionListener = new LoginListener(this);
		btnAbbrechen.addActionListener(actionListener);
		btnRegistrieren.addActionListener(actionListener);
		btnLogin.addActionListener(actionListener);

		//Set Textfields
		inp_username = new JTextField();
		form_springLayout.putConstraint(SpringLayout.NORTH, inp_username, -3, SpringLayout.NORTH, lblUsername);
		form_springLayout.putConstraint(SpringLayout.EAST, inp_username, -73, SpringLayout.EAST, panel_form);
		inp_username.setColumns(10);
		
		//Add Buttons to panel_buttons
		panel_buttons.add(btnAbbrechen);
		panel_buttons.add(btnRegistrieren);
		panel_buttons.add(btnLogin);
		
		//Add Labels and Textfields to form
		form_springLayout.putConstraint(SpringLayout.NORTH, lblUsername, 30, SpringLayout.NORTH, panel_form);
		form_springLayout.putConstraint(SpringLayout.WEST, lblUsername, 22, SpringLayout.WEST, panel_form);
		panel_form.add(lblUsername);
		panel_form.add(inp_username);
		inp_username.setColumns(10);
		
		form_springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 16, SpringLayout.SOUTH, lblUsername);
		form_springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblUsername);
		panel_form.add(lblPassword);
		
		inp_password = new JPasswordField();
		form_springLayout.putConstraint(SpringLayout.WEST, inp_password, 33, SpringLayout.EAST, lblPassword);
		form_springLayout.putConstraint(SpringLayout.EAST, inp_password, -73, SpringLayout.EAST, panel_form);
		form_springLayout.putConstraint(SpringLayout.WEST, inp_username, 0, SpringLayout.WEST, inp_password);
		form_springLayout.putConstraint(SpringLayout.NORTH, inp_password, -3, SpringLayout.NORTH, lblPassword);
		panel_form.add(inp_password);
		inp_password.setColumns(10);
				
		//Add title to contentPane
		contentPane.add(lblTitel, BorderLayout.NORTH);
		
		setVisible(true);
	}

	public String getInp_username() {
		return inp_username.getText();
	}

	public String getInp_password() {
		MD5 md5decoder = new MD5();
		return md5decoder.getMD5(inp_password.getText());
	}

}
