package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.grademasters.controller.Controller;
import ch.grademasters.gui.AddExam;
import ch.grademasters.gui.Grademasters;

public class AddExamListener implements ActionListener{

	private Grademasters grademasters;
	private AddExam addExam;
	
	public AddExamListener(Grademasters grademasters, AddExam addExam) {
		this.grademasters = grademasters;
		this.addExam = addExam;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Hinzufügen")){
			
			java.sql.Date selectedDate = (java.sql.Date) addExam.getDatePicker().getModel().getValue();
        
			Controller.getInstance().createExam(addExam.getBezeichnung().getText(), new Double(addExam.getNote().getText()), selectedDate, addExam.getNoteCountCheckBox().isSelected(), grademasters.getSelectedSubjectID());
			grademasters.setUser(Controller.getInstance().getUserInfos(grademasters.getUser().getUsername()));
			grademasters.createExamTableModel(grademasters.getExamIterator());
			grademasters.setEnabled(true);
			addExam.dispose();
		}else if(arg0.getActionCommand().equals("Abbrechen")){
			grademasters.setEnabled(true);
			addExam.dispose();			
		}
		
	}

}
