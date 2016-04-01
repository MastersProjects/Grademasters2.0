package ch.grademasters.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Grademasters extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel cards;
	
	private JPanel semesterCard;
	private JPanel subjectCard;
	private JPanel examCard;
	
	private JTable semesterTable;
	private JTable subjectTable;
	private JTable examTable;
	
	public Grademasters() {
		setTitle("GradeMasters");
		setBounds(100, 100, 527, 461);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		cards = new JPanel();
		getContentPane().add(cards);
		cards.setLayout(new CardLayout(20, 0));
		
		
		/*
		 * Semester Card
		 */
		semesterCard = new JPanel();
		cards.add(semesterCard, "semesterCard");
		semesterCard.setLayout(new BorderLayout(0, 0));
		
		JPanel semesterNorthPanel = new JPanel();
		semesterCard.add(semesterNorthPanel, BorderLayout.NORTH);
		GridBagLayout gbl_semesterNorthPanel = new GridBagLayout();
		gbl_semesterNorthPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_semesterNorthPanel.rowHeights = new int[]{0, 20, 14, 20, 0};
		gbl_semesterNorthPanel.columnWeights = new double[]{0.0, 3.0, 0.0, Double.MIN_VALUE};
		gbl_semesterNorthPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		semesterNorthPanel.setLayout(gbl_semesterNorthPanel);
		
		JLabel semesterLabel = new JLabel("Deine Semester");
		semesterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_semesterLabel = new GridBagConstraints();
		gbc_semesterLabel.insets = new Insets(0, 0, 5, 5);
		gbc_semesterLabel.fill = GridBagConstraints.BOTH;
		gbc_semesterLabel.gridx = 0;
		gbc_semesterLabel.gridy = 2;
		semesterNorthPanel.add(semesterLabel, gbc_semesterLabel);
		
		JButton semesterAddButton = new JButton("Semester hinzuf\u00FCgen");
		GridBagConstraints gbc_semesterAddButton = new GridBagConstraints();
		gbc_semesterAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_semesterAddButton.insets = new Insets(0, 0, 5, 0);
		gbc_semesterAddButton.gridx = 2;
		gbc_semesterAddButton.gridy = 2;
		semesterNorthPanel.add(semesterAddButton, gbc_semesterAddButton);
		
		JPanel semesterCenterPanel = new JPanel();
		semesterCard.add(semesterCenterPanel, BorderLayout.CENTER);
		semesterCenterPanel.setLayout(new BorderLayout(0, 0));
		
		semesterTable = new JTable();
		semesterCenterPanel.add(semesterTable);
		
		JPanel semesterSouthPanel = new JPanel();
		semesterCard.add(semesterSouthPanel, BorderLayout.SOUTH);
		semesterSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JButton semesterBackButton = new JButton("Abmelden");
		semesterSouthPanel.add(semesterBackButton);
		
		
		/*
		 * Subject Card
		 */
		subjectCard = new JPanel();
		cards.add(subjectCard, "subjectCard");
		subjectCard.setLayout(new BorderLayout(0, 0));
		
		JPanel subjectNorthPanel = new JPanel();
		subjectCard.add(subjectNorthPanel, BorderLayout.NORTH);
		GridBagLayout gbl_subjectNorthPanel = new GridBagLayout();
		gbl_subjectNorthPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_subjectNorthPanel.rowHeights = new int[]{0, 20, 14, 20, 0};
		gbl_subjectNorthPanel.columnWeights = new double[]{0.0, 3.0, 0.0, Double.MIN_VALUE};
		gbl_subjectNorthPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		subjectNorthPanel.setLayout(gbl_subjectNorthPanel);
		
		JLabel subjectLabel = new JLabel("Deine F\u00E4cher");
		subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_subjectLabel = new GridBagConstraints();
		gbc_subjectLabel.fill = GridBagConstraints.BOTH;
		gbc_subjectLabel.insets = new Insets(0, 0, 5, 5);
		gbc_subjectLabel.gridx = 0;
		gbc_subjectLabel.gridy = 2;
		subjectNorthPanel.add(subjectLabel, gbc_subjectLabel);
		
		JButton subjectAddButton = new JButton("Fach hinzuf\u00FCgen");
		GridBagConstraints gbc_subjectAddButton = new GridBagConstraints();
		gbc_subjectAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_subjectAddButton.insets = new Insets(0, 0, 5, 0);
		gbc_subjectAddButton.gridx = 2;
		gbc_subjectAddButton.gridy = 2;
		subjectNorthPanel.add(subjectAddButton, gbc_subjectAddButton);
		
		JPanel subjectCenterPanel = new JPanel();
		subjectCard.add(subjectCenterPanel, BorderLayout.CENTER);
		subjectCenterPanel.setLayout(new BorderLayout(0, 0));
		
		subjectTable = new JTable();
		subjectCenterPanel.add(subjectTable, BorderLayout.CENTER);
		
		JPanel subjectSouthPanle = new JPanel();
		subjectCard.add(subjectSouthPanle, BorderLayout.SOUTH);
		subjectSouthPanle.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JButton subjectBackButton = new JButton("Zur\u00FCck");
		subjectSouthPanle.add(subjectBackButton);
		
		
		/*
		 * Exam Card
		 */
		examCard = new JPanel();
		cards.add(examCard, "examCard");
		examCard.setLayout(new BorderLayout(0, 0));
		
		JPanel examNorthPanel = new JPanel();
		examCard.add(examNorthPanel, BorderLayout.NORTH);
		GridBagLayout gbl_examNorthPanel = new GridBagLayout();
		gbl_examNorthPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_examNorthPanel.rowHeights = new int[]{0, 20, 14, 20, 0};
		gbl_examNorthPanel.columnWeights = new double[]{0.0, 3.0, 0.0, Double.MIN_VALUE};
		gbl_examNorthPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		examNorthPanel.setLayout(gbl_examNorthPanel);
		
		JLabel examLabel = new JLabel("Deine Pr\u00FCfungen");
		examLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_examLabel = new GridBagConstraints();
		gbc_examLabel.fill = GridBagConstraints.BOTH;
		gbc_examLabel.insets = new Insets(0, 0, 5, 5);
		gbc_examLabel.gridx = 0;
		gbc_examLabel.gridy = 2;
		examNorthPanel.add(examLabel, gbc_examLabel);
		
		JButton examAddButton = new JButton("Pr\u00FCfung hinzuf\u00FCgen");
		GridBagConstraints gbc_examAddButton = new GridBagConstraints();
		gbc_examAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_examAddButton.insets = new Insets(0, 0, 5, 0);
		gbc_examAddButton.gridx = 2;
		gbc_examAddButton.gridy = 2;
		examNorthPanel.add(examAddButton, gbc_examAddButton);
		
		JPanel examCenterPanel = new JPanel();
		examCard.add(examCenterPanel, BorderLayout.CENTER);
		examCenterPanel.setLayout(new BorderLayout(0, 0));
		
		examTable = new JTable();
		examCenterPanel.add(examTable, BorderLayout.CENTER);
		
		JPanel examSouthPanel = new JPanel();
		examCard.add(examSouthPanel, BorderLayout.SOUTH);
		examSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JButton examBackButton = new JButton("Zur\u00FCck");
		examSouthPanel.add(examBackButton);
		
		//DisplayCard
//		CardLayout cl = (CardLayout)(cards.getLayout());
//	    cl.show(cards, "examCard");

		setVisible(true);
	}

}
