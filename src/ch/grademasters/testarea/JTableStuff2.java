package ch.grademasters.testarea;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import ch.grademasters.model.Semester;
import ch.grademasters.model.Subject;
import ch.grademasters.model.User;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JTableStuff2 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	
	private JPanel cards;
	
	private JPanel semesterCard;
	private JPanel subjectCard;
	private JPanel examCard;
	
	private JTable semesterTable;
	private JTable subjectTable;
	private JTable examTable;
	
	public JTableStuff2() {
		
		
		Subject subject1 = new Subject();
		subject1.setId(1);
		subject1.setName("Fach1");
		Subject subject2 = new Subject();
		subject1.setId(1);
		subject1.setName("Fach1");
		Subject subject3 = new Subject();
		subject1.setId(1);
		subject1.setName("Fach1");
		
		ArrayList<Subject> subjects1 = new ArrayList<Subject>();
		subjects1.add(subject1);
		subjects1.add(subject2);
		ArrayList<Subject> subjects2 = new ArrayList<Subject>();
		subjects2.add(subject3);
		
		Semester semester1 = new Semester();
		semester1.setId(1);
		semester1.setName("Semester1");
		semester1.setSchool("School1");
		semester1.setSubjects(subjects1);
		
		Semester semester2 = new Semester();		
		semester2.setId(2);
		semester2.setName("Semester2");
		semester2.setSchool("School2");
		semester2.setSubjects(subjects2);
		
		ArrayList<Semester> semesters = new ArrayList<Semester>();
		semesters.add(semester1);
		semesters.add(semester2);
		
		user = new User();
		user.setSemesters(semesters);
		
		
		Vector<Object> columnName = new Vector<Object>();
		columnName.add("Name");
		columnName.add("Schule");
		columnName.add("Fächer");		
		
		
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
		semesterCenterPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		semesterCenterPanel.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 4, 5, 5));
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1.1");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("1.2");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("1.3");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("New button");
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("New button");
		panel.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("New button");
		panel.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("New button");
		panel.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("New button");
		panel.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("New button");
		panel.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("New button");
		panel.add(btnNewButton_19);
		
	
		
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
