package ch.grademasters.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import ch.grademasters.actionlistener.AddExamListener;
import ch.grademasters.actionlistener.WindowClosingListener;
import ch.grademasters.utils.DateLabelFormatter;

public class AddExam extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Grademasters grademasters;
	
	private JTextField bezeichnung;
	private JTextField note;
	private JCheckBox noteCountCheckBox;
	private JDatePickerImpl datePicker;
	
	public AddExam(Grademasters grademasters) {
		this.setGrademasters(grademasters);
		setTitle("GradeMasters - Prüfung hinzuf\u00FCgen");
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
		
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Heute");
		p.put("text.month", "Monat");
		p.put("text.year", "Jahr");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		 	
		GridBagConstraints gbc_datum = new GridBagConstraints();
		gbc_datum.gridwidth = 2;
		gbc_datum.insets = new Insets(0, 0, 5, 5);
		gbc_datum.fill = GridBagConstraints.HORIZONTAL;
		gbc_datum.gridx = 3;
		gbc_datum.gridy = 3;
		getContentPane().add(datePicker, gbc_datum);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.anchor = GridBagConstraints.WEST;
		gbc_lblNote.insets = new Insets(0, 0, 5, 5);
		gbc_lblNote.gridx = 1;
		gbc_lblNote.gridy = 5;
		getContentPane().add(lblNote, gbc_lblNote);
		
		note = new JTextField();
		note.setColumns(10);
		GridBagConstraints gbc_note = new GridBagConstraints();
		gbc_note.gridwidth = 2;
		gbc_note.insets = new Insets(0, 0, 5, 5);
		gbc_note.fill = GridBagConstraints.HORIZONTAL;
		gbc_note.gridx = 3;
		gbc_note.gridy = 5;
		getContentPane().add(note, gbc_note);
		
		JLabel lblNoteZhlt = new JLabel("Note z\u00E4hlt");
		lblNoteZhlt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNoteZhlt = new GridBagConstraints();
		gbc_lblNoteZhlt.anchor = GridBagConstraints.WEST;
		gbc_lblNoteZhlt.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoteZhlt.gridx = 1;
		gbc_lblNoteZhlt.gridy = 7;
		getContentPane().add(lblNoteZhlt, gbc_lblNoteZhlt);
		
		noteCountCheckBox = new JCheckBox("");
		GridBagConstraints gbc_noteCountCheckBox = new GridBagConstraints();
		gbc_noteCountCheckBox.gridwidth = 2;
		gbc_noteCountCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_noteCountCheckBox.gridx = 3;
		gbc_noteCountCheckBox.gridy = 7;
		getContentPane().add(noteCountCheckBox, gbc_noteCountCheckBox);
		
		JButton abbrechenButton = new JButton("Abbrechen");
		abbrechenButton.addActionListener(new AddExamListener(grademasters, this));
		GridBagConstraints gbc_abbrechenButton = new GridBagConstraints();
		gbc_abbrechenButton.insets = new Insets(0, 0, 5, 5);
		gbc_abbrechenButton.anchor = GridBagConstraints.WEST;
		gbc_abbrechenButton.gridx = 1;
		gbc_abbrechenButton.gridy = 9;
		getContentPane().add(abbrechenButton, gbc_abbrechenButton);
		
		JButton hinzufügenButton = new JButton("Hinzufügen");
		hinzufügenButton.addActionListener(new AddExamListener(grademasters, this));
		GridBagConstraints gbc_hinzufügenButton = new GridBagConstraints();
		gbc_hinzufügenButton.anchor = GridBagConstraints.EAST;
		gbc_hinzufügenButton.insets = new Insets(0, 0, 5, 5);
		gbc_hinzufügenButton.gridx = 4;
		gbc_hinzufügenButton.gridy = 9;
		getContentPane().add(hinzufügenButton, gbc_hinzufügenButton);
		
		this.addWindowListener(new WindowClosingListener(grademasters));
		
		this.setVisible(true);
	}

	public JTextField getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(JTextField bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public JTextField getNote() {
		return note;
	}

	public void setNote(JTextField note) {
		this.note = note;
	}

	public JCheckBox getNoteCountCheckBox() {
		return noteCountCheckBox;
	}

	public void setNoteCountCheckBox(JCheckBox noteCountCheckBox) {
		this.noteCountCheckBox = noteCountCheckBox;
	}

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}

	public Grademasters getGrademasters() {
		return grademasters;
	}

	public void setGrademasters(Grademasters grademasters) {
		this.grademasters = grademasters;
	}

	
	
}
