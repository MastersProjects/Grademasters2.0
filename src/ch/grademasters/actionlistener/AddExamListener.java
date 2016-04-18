package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ch.grademasters.controller.Controller;
import ch.grademasters.gui.AddExam;
import ch.grademasters.gui.Grademasters;

public class AddExamListener implements ActionListener {

	private Grademasters grademasters;
	private AddExam addExam;

	public AddExamListener(Grademasters grademasters, AddExam addExam) {
		this.grademasters = grademasters;
		this.addExam = addExam;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Hinzufügen")) {
			String bezeichnung = addExam.getBezeichnung().getText();
			String noteString = addExam.getNote().getText();

			java.sql.Date selectedDate = (java.sql.Date) addExam.getDatePicker().getModel().getValue();
			boolean countNote = addExam.getNoteCountCheckBox().isSelected();

			if (bezeichnung.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Bezeichnung muss ausgef\u00fcllt sein!", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else if (noteString.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Note muss ausgef\u00fcllt sein!", "Warnung!",
						JOptionPane.ERROR_MESSAGE);
			} else {

				try {
					double note = new Double(noteString);
					if (note >= 0 && note <= 6) {
						Controller.getInstance().createExam(bezeichnung, note, selectedDate, countNote,
								grademasters.getSelectedSubjectID());
						grademasters
								.setUser(Controller.getInstance().getUserInfos(grademasters.getUser().getUsername()));
						grademasters.createExamTableModel(grademasters.getExamIterator());
						grademasters.setEnabled(true);
						addExam.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Bitte eine Zahl von 0-6 eingeben!", "Warnung!",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Bitte eine Zahl von 0-6 eingeben!", "Warnung!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (arg0.getActionCommand().equals("Abbrechen")) {
			grademasters.setEnabled(true);
			addExam.dispose();
		}

	}

}
