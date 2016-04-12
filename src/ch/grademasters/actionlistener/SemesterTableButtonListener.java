package ch.grademasters.actionlistener;

import java.awt.CardLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.TableCellRenderer;

import ch.grademasters.gui.Grademasters;
import ch.grademasters.model.Semester;
import ch.grademasters.model.Subject;
import ch.grademasters.utils.CostumTableModel;
import ch.grademasters.utils.JTableButtonRenderer;

public class SemesterTableButtonListener extends JTableButtonListener{

	public SemesterTableButtonListener(Grademasters grademasters) {
		super(grademasters);
	}

	@Override
	public void createTableModel(int iterator) {
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Fach");
		columnNames.add("Durchschnitt");
		columnNames.add("Prüfungen");
		
		Vector<Object> columnTypes = new Vector<Object>();
		columnTypes.add(String.class);
		columnTypes.add(Integer.class);
		columnTypes.add(JButton.class);
		
		Vector<Vector> datas = new Vector<Vector>();
		
		if(getGrademasters().getUser().getSemesters().get(iterator).getSubjects() != null){
			for(Subject subject : getGrademasters().getUser().getSemesters().get(iterator).getSubjects()){
				Vector<Object> row = new Vector<Object>();
				row.add(subject.getName());
				row.add(1);
				row.add("->");
	
				datas.add(row);
			}
		}
				
		getGrademasters().getSubjectTable().setModel(new CostumTableModel(columnNames, columnTypes, datas, new SubjectTableButtonListener(getGrademasters(), getGrademasters().getUser().getSemesters().get(iterator).getSubjects())));		
		getGrademasters().getSubjectTable().setEnabled(false);		
		if(getGrademasters().getUser().getSemesters().get(iterator).getSubjects() != null){
			TableCellRenderer buttonRenderer = new JTableButtonRenderer();
			getGrademasters().getSubjectTable().getColumn("Prüfungen").setCellRenderer(buttonRenderer);
			getGrademasters().getSubjectTable().addMouseListener(new JTableButtonMouseListener(getGrademasters().getSubjectTable()));	
		}
		
		CardLayout cl = (CardLayout)(getGrademasters().getCards().getLayout());
	    cl.show(getGrademasters().getCards(), "subjectCard");		
	}

	


}
