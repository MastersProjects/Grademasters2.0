package ch.grademasters.utils;

import java.awt.Component;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JTableButtonRenderer implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JButton button = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/images/pfeil.png"));
			img = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
			button.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return button;
	}

}
