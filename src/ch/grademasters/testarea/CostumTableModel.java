package ch.grademasters.testarea;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class CostumTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    
    private final Vector<Object> COLUMN_NAMES;
    private final Vector<Object> COLUMN_TYPES;
    private final Vector<Vector> DATAS;
    private ArrayList<JButton> buttons;
    private JTableStuff jTableStuff;
    private ButtonListener buttonListener;
    
	public CostumTableModel(Vector<Object> columnNames, Vector<Object> columnTypes, Vector<Vector> datas, JTableStuff jTableStuff) {
		this.COLUMN_NAMES = columnNames;
		this.COLUMN_TYPES = columnTypes;
		this.DATAS = datas;
		this.jTableStuff = jTableStuff;
		buttonListener = new ButtonListener(jTableStuff);
		
		buttons = new ArrayList<JButton>();
		for(Vector rows : DATAS){
			JButton button = new JButton((String)rows.get(rows.size()-1));
			button.addActionListener(buttonListener);
			buttons.add(button);
		}
		buttonListener.setButtons(buttons);
	}
    
    @Override public int getColumnCount() {
        return COLUMN_NAMES.size();
    }

    @Override public int getRowCount() {
        return DATAS.size();
    }

    @Override public String getColumnName(int columnIndex) {
        return (String) COLUMN_NAMES.get(columnIndex);
    }

    @Override public Class<?> getColumnClass(int columnIndex) {
        return (Class<?>) COLUMN_TYPES.get(columnIndex);
    }

    @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
            /*Adding components*/
      	
    	if(COLUMN_TYPES.get(columnIndex) == JButton.class ){
    		return buttons.get(rowIndex);
    	}else{
//    		System.out.println((DATAS.get(rowIndex)).get(columnIndex));
    		return (DATAS.get(rowIndex)).get(columnIndex);
    	}
    }   
}
