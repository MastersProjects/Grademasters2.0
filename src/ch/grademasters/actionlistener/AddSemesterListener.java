package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ch.grademasters.controller.Controller;
import ch.grademasters.gui.AddSemester;
import ch.grademasters.gui.Grademasters;

public class AddSemesterListener implements ActionListener {

	private Grademasters grademasters;
	private AddSemester addSemester;

	public AddSemesterListener(Grademasters grademasters, AddSemester addSemester) {
		this.grademasters = grademasters;
		this.addSemester = addSemester;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Hinzufügen")) {
			String bezeichnung = addSemester.getBezeichnung().getText();
			String schule = addSemester.getSchule().getText();
			if (bezeichnung.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Bezeichnung muss ausgef\u00fcllt sein!", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else if (schule.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Schule muss ausgef\u00fcllt sein!", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				Controller.getInstance().createSemester(bezeichnung, schule, grademasters.getUser().getUsername());
				grademasters.setUser(Controller.getInstance().getUserInfos(grademasters.getUser().getUsername()));
				grademasters.createSemesterTableModel();
				grademasters.setEnabled(true);
				addSemester.dispose();
			}
		} else if (arg0.getActionCommand().equals("Abbrechen")) {
			grademasters.setEnabled(true);
			addSemester.dispose();
		}

	}

}
