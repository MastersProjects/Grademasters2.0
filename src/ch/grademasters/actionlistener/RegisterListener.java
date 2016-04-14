package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ch.grademasters.controller.Controller;
import ch.grademasters.gui.Login;
import ch.grademasters.gui.Registration;

public class RegisterListener implements ActionListener {

	private JButton button;
	private JFrame frame;

	public RegisterListener(JFrame frame) {
		this.setFrame(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		button = (JButton) e.getSource();
		String username = ((Registration) getFrame()).getInp_username();
		String firstname = ((Registration) getFrame()).getInp_firstname();
		String lastname = ((Registration) getFrame()).getInp_lastname();
		String email = ((Registration) getFrame()).getInp_email();
		String password = ((Registration) getFrame()).getInp_password1();
		String password2 = ((Registration) getFrame()).getInp_password2();
		if (button.getText().equals("Registrieren")) {
			final Pattern pattern = Pattern
					.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

			if (username.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Username muss ausgef\u00fcllt sein!", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else if (email.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Email muss ausgef\u00fcllt sein!", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else if (!pattern.matcher(email).matches()) {
				JOptionPane.showMessageDialog(null, "Email ist ung\u00fcltig!", "Warnung!", JOptionPane.ERROR_MESSAGE);
			} else if (password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Passwort muss ausgef\u00fcllt sein", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else if (!(password.equals(password2))) {
				JOptionPane.showMessageDialog(null, "Passw\u00f6rter stimmen nicht \u00fcberein", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else if (Controller.getInstance().getAllUser().contains(username)) {
				JOptionPane.showMessageDialog(null, "Username ist bereits vergeben", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				Controller.getInstance().registerUser(username, firstname, lastname, email, password);
				JOptionPane.showMessageDialog(null, "Sie wurden erfolgreich registriert", "Registration!",
						JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				new Login();
			}
		} else if (button.getText().equals("Abbrechen")) {
			new Login();
			frame.dispose();
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
