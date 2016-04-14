package ch.grademasters.actionlistener;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import ch.grademasters.gui.Grademasters;
import ch.grademasters.model.Exam;
import ch.grademasters.model.Subject;
import ch.grademasters.utils.CostumTableModel;
import ch.grademasters.utils.JTableButtonRenderer;

public class SubjectTableButtonListener extends JTableButtonListener {
	
	ArrayList<Subject> subjects;
	
	public SubjectTableButtonListener(Grademasters grademasters, ArrayList<Subject> subjects) {
		super(grademasters);
		this.subjects = subjects;
	}

	@Override
	public void createTableModel(int iterator) {
		getGrademasters().createExamTableModel(iterator, subjects);
		
		CardLayout cl = (CardLayout)(getGrademasters().getCards().getLayout());
	    cl.show(getGrademasters().getCards(), "examCard");	
	    

	}

}
