package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainListener implements ActionListener{
	private JButton button;
	private JFrame frame;
	
	public MainListener(JFrame frame) {
		this.setFrame(frame);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		button = (JButton) e.getSource();
		if(button.getText().equals("Semester hinzufügen")){
			//ToDo
			System.out.println("semester hinzufügen");
		} else if (button.getText().equals("Abmelden")){
			//ToDo
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
