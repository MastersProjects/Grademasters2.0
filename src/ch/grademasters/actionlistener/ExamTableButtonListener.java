package ch.grademasters.actionlistener;

import java.util.ArrayList;

import ch.grademasters.gui.Grademasters;
import ch.grademasters.model.Exam;

public class ExamTableButtonListener extends JTableButtonListener {

	private ArrayList<Exam> exams;
	
	public ExamTableButtonListener(Grademasters grademasters, ArrayList<Exam> exams) {
		super(grademasters);
		this.exams = exams;
	}

	@Override
	public void createTableModel(int iterator) {
		System.out.println(exams.get(iterator).getName());

	}

}
