package ch.grademasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import ch.grademasters.gui.Grademasters;

/**
 * An abstract Listener class for JButton in JTable
 *
 */
public abstract class JTableButtonListener implements ActionListener{
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private Grademasters grademasters;
	
	public JTableButtonListener(Grademasters grademasters) {
		this.setGrademasters(grademasters);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0; 
		while(i<buttons.size()){		
			if(buttons.get(i) == e.getSource()){
				
				createTableModel(i);
			}
			i++;
		}
		
	}
	
	/**
	 * After actionPerformed create Table and change Card
	 * @param iterator
	 */
	public abstract void createTableModel(int iterator);
	
	public ArrayList<JButton> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<JButton> buttons) {
		this.buttons = buttons;
	}
	
	public void addButton(JButton button){
		buttons.add(button);
	}

	public Grademasters getGrademasters() {
		return grademasters;
	}

	public void setGrademasters(Grademasters grademasters) {
		this.grademasters = grademasters;
	}
}
