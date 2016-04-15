package ch.grademasters.actionlistener;

import java.awt.CardLayout;

import ch.grademasters.gui.Grademasters;

public class SemesterTableButtonListener extends JTableButtonListener{

	public SemesterTableButtonListener(Grademasters grademasters) {
		super(grademasters);
	}

	@Override
	public void createTableModel(int iterator) {
		getGrademasters().createSubjectTableModel(iterator);		
		CardLayout cl = (CardLayout)(getGrademasters().getCards().getLayout());
	    cl.show(getGrademasters().getCards(), "subjectCard");		
	}

	


}
