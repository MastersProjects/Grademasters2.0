package ch.grademasters.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ch.grademasters.actionlistener.AddSemesterListener;
import ch.grademasters.actionlistener.WindowClosingListener;

public class AddSemester extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Grademasters grademasters;
	
	private JTextField bezeichnung;
	private JTextField schule;
	
	public AddSemester(Grademasters grademasters) {
		
		this.grademasters = grademasters;
		
		setTitle("GradeMasters - Semester hinzuf\u00FCgen");
		setBounds(100, 100, 400, 210);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		JLabel lblSchule = new JLabel("Schule");
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
		
		JButton abbrechenButton = new JButton("Abbrechen");
		abbrechenButton.addActionListener(new AddSemesterListener(grademasters, this));
		GridBagConstraints gbc_abbrechenButton = new GridBagConstraints();
		gbc_abbrechenButton.insets = new Insets(0, 0, 5, 5);
		gbc_abbrechenButton.anchor = GridBagConstraints.WEST;
		gbc_abbrechenButton.gridx = 1;
		gbc_abbrechenButton.gridy = 5;
		getContentPane().add(abbrechenButton, gbc_abbrechenButton);
		
		JButton hinzufügenButton = new JButton("Hinzuf\u00FCgen");
		hinzufügenButton.addActionListener(new AddSemesterListener(grademasters, this));
		GridBagConstraints gbc_hinzufügenButton = new GridBagConstraints();
		gbc_hinzufügenButton.anchor = GridBagConstraints.EAST;
		gbc_hinzufügenButton.insets = new Insets(0, 0, 5, 5);
		gbc_hinzufügenButton.gridx = 4;
		gbc_hinzufügenButton.gridy = 5;
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

	public JTextField getSchule() {
		return schule;
	}

	public void setSchule(JTextField schule) {
		this.schule = schule;
	}

	
	
}
