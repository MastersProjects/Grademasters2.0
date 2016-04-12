package ch.grademasters.actionlistener;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.TableCellRenderer;

import ch.grademasters.gui.Grademasters;
import ch.grademasters.model.Exam;
import ch.grademasters.utils.CostumTableModel;
import ch.grademasters.utils.JTableButtonRenderer;

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
