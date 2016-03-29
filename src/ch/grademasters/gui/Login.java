package ch.grademasters.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//InputField
	private JTextField inp_username;
	private JTextField textField;
	
	//Label
	private JLabel lblUsername;
	private JLabel lblPasswort;
	private JLabel lblTitel;
	
	//Panel
	private JPanel panel_buttons;
	private JPanel panel_form;
	private JPanel contentPane;
	
	//Button
	private JButton btnAbbrechen;
	private JButton btnRegistrieren;
	private JButton btnLogin;

	public Login() {
		//Jpanel Settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 225);
		
		//Set Panels
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Panel for Buttons
		panel_buttons = new JPanel();
		contentPane.add(panel_buttons, BorderLayout.SOUTH);
		panel_buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Panel for form
		panel_form = new JPanel();
		contentPane.add(panel_form, BorderLayout.CENTER);
		panel_form.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		//Set Labels
		lblTitel = new JLabel("GradeMasters Login");
		lblTitel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername = new JLabel("Username");
		lblPasswort = new JLabel("Passwort");
		
		//Set Buttons
		btnAbbrechen = new JButton("Abbrechen");
		btnRegistrieren = new JButton("Registrieren");
		btnLogin = new JButton("Login");

		//Set Textfields
		inp_username = new JTextField();
		inp_username.setColumns(10);

		textField = new JTextField();
		textField.setColumns(10);
		
		//Add Buttons to panel_buttons
		panel_buttons.add(btnAbbrechen);
		panel_buttons.add(btnLogin);
		panel_buttons.add(btnRegistrieren);
		
		//Add Labels and Textfields to form
		panel_form.add(lblUsername, "4, 4");
		panel_form.add(lblPasswort, "4, 6");
		panel_form.add(inp_username, "10, 4, left, default");
		panel_form.add(textField, "10, 6, left, default");
		
		//Add title to contentPane
		contentPane.add(lblTitel, BorderLayout.NORTH);
	}

}
