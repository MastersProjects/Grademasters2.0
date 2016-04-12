package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RegisterListener implements ActionListener {

	private JButton button;
	private JFrame frame;
	
	public RegisterListener(JFrame frame) {
		this.setFrame(frame);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		button = (JButton) e.getSource();
		if (button.getText().equals("Registrieren")){
			
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
