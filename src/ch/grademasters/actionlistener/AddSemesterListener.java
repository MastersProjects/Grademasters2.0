package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.grademasters.controller.Controller;
import ch.grademasters.gui.AddSemester;
import ch.grademasters.gui.Grademasters;

public class AddSemesterListener implements ActionListener{

	private Grademasters grademasters;
	private AddSemester addSemester;
	
	public AddSemesterListener(Grademasters grademasters, AddSemester addSemester) {
		this.grademasters = grademasters;
		this.addSemester = addSemester;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Hinzufügen")){
			Controller.getInstance().createSemester(addSemester.getBezeichnung().getText(), addSemester.getSchule().getText(), grademasters.getUser().getUsername());
			grademasters.setUser(Controller.getInstance().getUserInfos(grademasters.getUser().getUsername()));
			grademasters.createSemesterTableModel();
			grademasters.setEnabled(true);
			addSemester.dispose();
		}else if(arg0.getActionCommand().equals("Abbrechen")){
			grademasters.setEnabled(true);
			addSemester.dispose();			
		}
		
	}

}
