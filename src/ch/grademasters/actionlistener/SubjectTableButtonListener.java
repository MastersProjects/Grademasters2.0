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
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Name");
		columnNames.add("Datum");
		columnNames.add("Durchschnitt");
		columnNames.add("Prüfung");
		
		Vector<Object> columnTypes = new Vector<Object>();
		columnTypes.add(String.class);
		columnTypes.add(String.class);
		columnTypes.add(Integer.class);
		columnTypes.add(JButton.class);
		
		@SuppressWarnings("rawtypes")
		Vector<Vector> datas = new Vector<Vector>();
		
		if(subjects.get(iterator).getExams() != null){
			for(Exam exam : subjects.get(iterator).getExams()){
				Vector<Object> row = new Vector<Object>();
				row.add(exam.getName());
				row.add(1);
				row.add("->");
	
				datas.add(row);
			}
		}
				
		getGrademasters().getSubjectTable().setModel(new CostumTableModel(columnNames, columnTypes, datas, new ExamTableButtonListener(getGrademasters(), subjects.get(iterator).getExams())));		
		getGrademasters().getSubjectTable().setEnabled(false);
		
		if(subjects.get(iterator).getExams() != null){
			TableCellRenderer buttonRenderer = new JTableButtonRenderer();
			getGrademasters().getSubjectTable().getColumn("Prüfungen").setCellRenderer(buttonRenderer);
			getGrademasters().getSubjectTable().addMouseListener(new JTableButtonMouseListener(getGrademasters().getSubjectTable()));
		}
		
		//Allignement Center
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		getGrademasters().getSubjectTable().getColumnModel().getColumn(2).setCellRenderer(tableRenderer);
		
		CardLayout cl = (CardLayout)(getGrademasters().getCards().getLayout());
	    cl.show(getGrademasters().getCards(), "examCard");	
	    

	}

}
