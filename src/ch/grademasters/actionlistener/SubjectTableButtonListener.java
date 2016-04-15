package ch.grademasters.actionlistener;

import java.awt.CardLayout;

import ch.grademasters.gui.Grademasters;

public class SubjectTableButtonListener extends JTableButtonListener {
	
	
	public SubjectTableButtonListener(Grademasters grademasters) {
		super(grademasters);
	}

	@Override
	public void createTableModel(int iterator) {
		getGrademasters().createExamTableModel(iterator);
		
		CardLayout cl = (CardLayout)(getGrademasters().getCards().getLayout());
	    cl.show(getGrademasters().getCards(), "examCard");	
	    

	}

}
