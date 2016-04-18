package ch.grademasters.actionlistener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ch.grademasters.gui.Grademasters;

public class BackButtonListener implements ActionListener{

	private JPanel cards;
	private String backCard;
	private Grademasters grademasters;
	
	public BackButtonListener(JPanel cards, String backCard, Grademasters grademasters) {
		this.cards = cards;
		this.backCard = backCard;
		this.grademasters = grademasters;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(backCard.equals("Abmelden")){
			System.exit(0);
		}else{
			if(backCard.equals("semesterCard")){
				grademasters.createSemesterTableModel();
			}else if(backCard.equals("subjectCard")){
				grademasters.createSubjectTableModel(grademasters.getSubjectIterator());
			}
			CardLayout cl = (CardLayout)(cards.getLayout());
		    cl.show(cards, backCard);
		}
		
	}

}
