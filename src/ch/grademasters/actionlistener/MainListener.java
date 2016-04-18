package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.grademasters.gui.AddExam;
import ch.grademasters.gui.AddSemester;
import ch.grademasters.gui.AddSubject;
import ch.grademasters.gui.Grademasters;

public class MainListener implements ActionListener{
	private Grademasters grademasters;
	
	public MainListener(Grademasters grademasters) {
		this.grademasters = grademasters;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonText = e.getActionCommand();
		if(buttonText.equals("Semester hinzufügen")){
			grademasters.setEnabled(false);
			new AddSemester(grademasters);
		} else if (buttonText.equals("Fach hinzufügen")){
			grademasters.setEnabled(false);
			new AddSubject(grademasters);
		} else if (buttonText.equals("Prüfung hinzufügen")){
			grademasters.setEnabled(false);
			new AddExam(grademasters);
		}
	}

	
}
