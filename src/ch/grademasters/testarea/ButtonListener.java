package ch.grademasters.testarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import ch.grademasters.model.Subject;
import ch.grademasters.model.User;

public class ButtonListener implements ActionListener{

	ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JTableStuff jTableStuff;
	
	public ButtonListener(JTableStuff jTableStuff) {
		this.jTableStuff = jTableStuff;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0; 
		while(i<buttons.size()){		
			if(buttons.get(i) == e.getSource()){
				for(Subject subject : jTableStuff.getUser().getSemesters().get(i).getSubjects()){
					System.out.println(subject.getName());
				}
			}
			i++;
		}
		
	}
	
	public ArrayList<JButton> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<JButton> buttons) {
		this.buttons = buttons;
	}
	
	public void addButton(JButton button){
		buttons.add(button);
	}

}
