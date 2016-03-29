package ch.grademasters.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitel = new JLabel("GradeMasters Login");
		contentPane.add(lblTitel, BorderLayout.NORTH);
		
		JPanel panel_buttons = new JPanel();
		contentPane.add(panel_buttons, BorderLayout.SOUTH);
		panel_buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		panel_buttons.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_buttons.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_buttons.add(btnNewButton_2);
		
		JPanel panel_form = new JPanel();
		contentPane.add(panel_form, BorderLayout.CENTER);
		panel_form.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
