package ch.grademasters.utils;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JTableCheckBoxRenderer implements TableCellRenderer {

	@SuppressWarnings("deprecation")
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		JCheckBox checkBox = new JCheckBox();
		checkBox.setLabel("Zählt");
		checkBox.setEnabled(false);
		checkBox.setSelected((boolean)value);
		return checkBox;
	}

}
