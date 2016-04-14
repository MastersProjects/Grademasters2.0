package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.grademasters.controller.Controller;
import ch.grademasters.gui.AddSubject;
import ch.grademasters.gui.Grademasters;

public class AddSubjectListener implements ActionListener{

	private Grademasters grademasters;
	private AddSubject addSubject;
	
	public AddSubjectListener(Grademasters grademasters, AddSubject addSubject) {
		this.grademasters = grademasters;
		this.addSubject = addSubject;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Hinzufügen")){
			Controller.getInstance().createSubject(addSubject.getBezeichnung().getText(), grademasters.getSelectedSemesterID());
			grademasters.setUser(Controller.getInstance().getUserInfos(grademasters.getUser().getUsername()));
			grademasters.createSubjectTableModel(grademasters.getSubjectIterator());
			grademasters.setEnabled(true);
			addSubject.dispose();
		}else if(arg0.getActionCommand().equals("Abbrechen")){
			grademasters.setEnabled(true);
			addSubject.dispose();			
		}
		
	}

}
