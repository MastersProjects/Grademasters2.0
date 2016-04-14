package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ch.grademasters.controller.Controller;
import ch.grademasters.gui.Grademasters;
import ch.grademasters.gui.Login;
import ch.grademasters.gui.Registration;

public class LoginListener implements ActionListener {
	
	private JButton button;
	private JFrame frame;
	
	public LoginListener(JFrame frame) {
		this.setFrame(frame);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		button = (JButton) e.getSource();
		if(button.getText().equals("Login")){
			String username = ((Login) getFrame()).getInp_username();
			String password = ((Login) getFrame()).getInp_password();
			
			System.out.println(password);
			if(Controller.getInstance().loginUser(username, password)==true){
				new Grademasters(Controller.getInstance().getUserInfos(username));
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Username und Password stimmen nicht \u00fcberein", "Login fehlgeschlagen", JOptionPane.ERROR_MESSAGE);
			} 
		} else if (button.getText().equals("Registrieren")){
			new Registration();
			frame.dispose();
		} else if (button.getText().equals("Abbrechen")){
			System.exit(0);
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
