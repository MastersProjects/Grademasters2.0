package ch.grademasters.gui;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import ch.grademasters.actionlistener.WindowClosingListener;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;

public class AddExam extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Grademasters grademasters;
	
	private JTextField bezeichnung;
	private JTextField schule;
	private JTextField textField;
	
	public AddExam(Grademasters grademasters) {
		this.grademasters = grademasters;
		setTitle("GradeMasters - Note hinzuf\u00FCgen");
		setBounds(100, 100, 400, 347);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Bezeichnung");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		bezeichnung = new JTextField();
		GridBagConstraints gbc_bezeichnung = new GridBagConstraints();
		gbc_bezeichnung.gridwidth = 2;
		gbc_bezeichnung.insets = new Insets(0, 0, 5, 5);
		gbc_bezeichnung.fill = GridBagConstraints.HORIZONTAL;
		gbc_bezeichnung.gridx = 3;
		gbc_bezeichnung.gridy = 1;
		getContentPane().add(bezeichnung, gbc_bezeichnung);
		bezeichnung.setColumns(10);
		
		JLabel lblSchule = new JLabel("Datum");
		lblSchule.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSchule = new GridBagConstraints();
		gbc_lblSchule.anchor = GridBagConstraints.WEST;
		gbc_lblSchule.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchule.gridx = 1;
		gbc_lblSchule.gridy = 3;
		getContentPane().add(lblSchule, gbc_lblSchule);
		
		schule = new JTextField();
		GridBagConstraints gbc_schule = new GridBagConstraints();
		gbc_schule.gridwidth = 2;
		gbc_schule.insets = new Insets(0, 0, 5, 5);
		gbc_schule.fill = GridBagConstraints.HORIZONTAL;
		gbc_schule.gridx = 3;
		gbc_schule.gridy = 3;
		getContentPane().add(schule, gbc_schule);
		schule.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.anchor = GridBagConstraints.WEST;
		gbc_lblNote.insets = new Insets(0, 0, 5, 5);
		gbc_lblNote.gridx = 1;
		gbc_lblNote.gridy = 5;
		getContentPane().add(lblNote, gbc_lblNote);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 5;
		getContentPane().add(textField, gbc_textField);
		
		JLabel lblNoteZhlt = new JLabel("Note z\u00E4hlt");
		lblNoteZhlt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNoteZhlt = new GridBagConstraints();
		gbc_lblNoteZhlt.anchor = GridBagConstraints.WEST;
		gbc_lblNoteZhlt.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoteZhlt.gridx = 1;
		gbc_lblNoteZhlt.gridy = 7;
		getContentPane().add(lblNoteZhlt, gbc_lblNoteZhlt);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.gridwidth = 2;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 3;
		gbc_chckbxNewCheckBox.gridy = 7;
		getContentPane().add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JButton abbrechenButton = new JButton("Abbrechen");
		GridBagConstraints gbc_abbrechenButton = new GridBagConstraints();
		gbc_abbrechenButton.insets = new Insets(0, 0, 5, 5);
		gbc_abbrechenButton.anchor = GridBagConstraints.WEST;
		gbc_abbrechenButton.gridx = 1;
		gbc_abbrechenButton.gridy = 9;
		getContentPane().add(abbrechenButton, gbc_abbrechenButton);
		
		JButton hinzufügenButton = new JButton("Hinzuf\u00FCgen");
		GridBagConstraints gbc_hinzufügenButton = new GridBagConstraints();
		gbc_hinzufügenButton.anchor = GridBagConstraints.EAST;
		gbc_hinzufügenButton.insets = new Insets(0, 0, 5, 5);
		gbc_hinzufügenButton.gridx = 4;
		gbc_hinzufügenButton.gridy = 9;
		getContentPane().add(hinzufügenButton, gbc_hinzufügenButton);
		
		this.addWindowListener(new WindowClosingListener(grademasters));
		
		this.setVisible(true);
	}

	
	
}
