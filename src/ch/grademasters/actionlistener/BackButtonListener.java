package ch.grademasters.actionlistener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class BackButtonListener implements ActionListener{

	private JPanel cards;
	private String backCard;
	
	public BackButtonListener(JPanel cards, String backCard) {
		this.cards = cards;
		this.backCard = backCard;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(backCard.equals("Abmelden")){
			System.exit(0);
		}else{
			CardLayout cl = (CardLayout)(cards.getLayout());
		    cl.show(cards, backCard);
		}
		
	}

}
