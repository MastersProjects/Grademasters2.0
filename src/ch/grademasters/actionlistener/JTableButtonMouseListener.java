package ch.grademasters.actionlistener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;

public class JTableButtonMouseListener extends MouseAdapter {
    private final JTable table;

    public JTableButtonMouseListener(JTable table) {
        this.table = table;
    }

    public void mouseClicked(MouseEvent e) {
    	//TODO #Issue 1 Bug: When going one Card back and press button it clicks twice ore more
    	System.out.println("click1");
        int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the column of the button
        int row = e.getY()/table.getRowHeight(); //get the row of the button

        //Checking if the button column is being clicked
        if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
            Object value = table.getValueAt(row, column);
            if (value instanceof JButton) {

            	//perform a click event
            	System.out.println("click2");

                ((JButton)value).doClick();
            }
        }
    }
}
