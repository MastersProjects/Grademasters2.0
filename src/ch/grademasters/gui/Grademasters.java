package ch.grademasters.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import ch.grademasters.actionlistener.BackButtonListener;
import ch.grademasters.actionlistener.ExamTableButtonListener;
import ch.grademasters.actionlistener.JTableButtonMouseListener;
import ch.grademasters.actionlistener.MainListener;
import ch.grademasters.actionlistener.SemesterTableButtonListener;
import ch.grademasters.actionlistener.SubjectTableButtonListener;
import ch.grademasters.model.Exam;
import ch.grademasters.model.Semester;
import ch.grademasters.model.Subject;
import ch.grademasters.model.User;
import ch.grademasters.utils.CostumTableModel;
import ch.grademasters.utils.JTableButtonRenderer;
import ch.grademasters.utils.JTableCheckBoxRenderer;

public class Grademasters extends JFrame {

	private static final long serialVersionUID = 1L;

	private User user;
	private int selectedSemesterID;
	private int selectedSubjectID;
	private int subjectIterator;
	private int examIterator;

	private JPanel cards;

	private JPanel semesterCard;
	private JPanel subjectCard;
	private JPanel examCard;

	private JTable semesterTable;
	private JTable subjectTable;
	private JTable examTable;

	private MainListener actionListener;

	public Grademasters(User user) {
		this.setUser(user);
		setTitle("GradeMasters");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img = null;
		try {
			img = ImageIO.read(getClass().getResource("/images/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(img);
		setBounds(100, 100, 527, 461);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		cards = new JPanel();
		getContentPane().add(cards);
		cards.setLayout(new CardLayout(20, 0));

		actionListener = new MainListener(this);

		/*
		 * Semester Card
		 */
		semesterCard = new JPanel();
		cards.add(semesterCard, "semesterCard");
		semesterCard.setLayout(new BorderLayout(0, 0));

		JPanel semesterNorthPanel = new JPanel();
		semesterCard.add(semesterNorthPanel, BorderLayout.NORTH);
		GridBagLayout gbl_semesterNorthPanel = new GridBagLayout();
		gbl_semesterNorthPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_semesterNorthPanel.rowHeights = new int[] { 0, 20, 14, 20, 0 };
		gbl_semesterNorthPanel.columnWeights = new double[] { 0.0, 3.0, 0.0, Double.MIN_VALUE };
		gbl_semesterNorthPanel.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		semesterNorthPanel.setLayout(gbl_semesterNorthPanel);

		JLabel semesterLabel = new JLabel("Deine Semester");
		semesterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_semesterLabel = new GridBagConstraints();
		gbc_semesterLabel.insets = new Insets(0, 0, 5, 5);
		gbc_semesterLabel.fill = GridBagConstraints.BOTH;
		gbc_semesterLabel.gridx = 0;
		gbc_semesterLabel.gridy = 2;
		semesterNorthPanel.add(semesterLabel, gbc_semesterLabel);

		JButton semesterAddButton = new JButton("Semester hinzufügen");
		semesterAddButton.addActionListener(actionListener);
		GridBagConstraints gbc_semesterAddButton = new GridBagConstraints();
		gbc_semesterAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_semesterAddButton.insets = new Insets(0, 0, 5, 0);
		gbc_semesterAddButton.gridx = 2;
		gbc_semesterAddButton.gridy = 2;
		semesterNorthPanel.add(semesterAddButton, gbc_semesterAddButton);

		JPanel semesterCenterPanel = new JPanel();
		semesterCard.add(semesterCenterPanel, BorderLayout.CENTER);
		semesterCenterPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane semesterScrollPane = new JScrollPane();
		semesterCenterPanel.add(semesterScrollPane, BorderLayout.CENTER);

		semesterTable = new JTable();
		// Design Stuff
		semesterTable.setShowVerticalLines(false);
		semesterTable.setRowHeight(40);
		semesterTable.setShowHorizontalLines(false);
		semesterTable.setIntercellSpacing(new Dimension(30, 10));

		semesterScrollPane.setViewportView(semesterTable);

		JPanel semesterSouthPanel = new JPanel();
		semesterCard.add(semesterSouthPanel, BorderLayout.SOUTH);
		semesterSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		JButton semesterLogoutButton = new JButton("Abmelden");
		semesterSouthPanel.add(semesterLogoutButton);
		semesterLogoutButton.addActionListener(new BackButtonListener(cards, "Abmelden", this));

		/*
		 * Subject Card
		 */
		subjectCard = new JPanel();
		cards.add(subjectCard, "subjectCard");
		subjectCard.setLayout(new BorderLayout(0, 0));

		JPanel subjectNorthPanel = new JPanel();
		subjectCard.add(subjectNorthPanel, BorderLayout.NORTH);
		GridBagLayout gbl_subjectNorthPanel = new GridBagLayout();
		gbl_subjectNorthPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_subjectNorthPanel.rowHeights = new int[] { 0, 20, 14, 20, 0 };
		gbl_subjectNorthPanel.columnWeights = new double[] { 0.0, 3.0, 0.0, Double.MIN_VALUE };
		gbl_subjectNorthPanel.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		subjectNorthPanel.setLayout(gbl_subjectNorthPanel);

		JLabel subjectLabel = new JLabel("Deine F\u00E4cher");
		subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_subjectLabel = new GridBagConstraints();
		gbc_subjectLabel.fill = GridBagConstraints.BOTH;
		gbc_subjectLabel.insets = new Insets(0, 0, 5, 5);
		gbc_subjectLabel.gridx = 0;
		gbc_subjectLabel.gridy = 2;
		subjectNorthPanel.add(subjectLabel, gbc_subjectLabel);

		JButton subjectAddButton = new JButton("Fach hinzufügen");
		subjectAddButton.addActionListener(actionListener);
		GridBagConstraints gbc_subjectAddButton = new GridBagConstraints();
		gbc_subjectAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_subjectAddButton.insets = new Insets(0, 0, 5, 0);
		gbc_subjectAddButton.gridx = 2;
		gbc_subjectAddButton.gridy = 2;
		subjectNorthPanel.add(subjectAddButton, gbc_subjectAddButton);

		JPanel subjectCenterPanel = new JPanel();
		subjectCard.add(subjectCenterPanel, BorderLayout.CENTER);
		subjectCenterPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane subjectScrollPane = new JScrollPane();
		subjectCenterPanel.add(subjectScrollPane, BorderLayout.CENTER);

		setSubjectTable(new JTable());
		// Design Stuff
		getSubjectTable().setShowVerticalLines(false);
		getSubjectTable().setRowHeight(40);
		getSubjectTable().setShowHorizontalLines(false);
		getSubjectTable().setIntercellSpacing(new Dimension(30, 10));

		subjectScrollPane.setViewportView(getSubjectTable());

		JPanel subjectSouthPanle = new JPanel();
		subjectCard.add(subjectSouthPanle, BorderLayout.SOUTH);
		subjectSouthPanle.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		JButton subjectBackButton = new JButton("Zur\u00FCck");
		subjectSouthPanle.add(subjectBackButton);
		subjectBackButton.addActionListener(new BackButtonListener(cards, "semesterCard", this));

		/*
		 * Exam Card
		 */
		examCard = new JPanel();
		cards.add(examCard, "examCard");
		examCard.setLayout(new BorderLayout(0, 0));

		JPanel examNorthPanel = new JPanel();
		examCard.add(examNorthPanel, BorderLayout.NORTH);
		GridBagLayout gbl_examNorthPanel = new GridBagLayout();
		gbl_examNorthPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_examNorthPanel.rowHeights = new int[] { 0, 20, 14, 20, 0 };
		gbl_examNorthPanel.columnWeights = new double[] { 0.0, 3.0, 0.0, Double.MIN_VALUE };
		gbl_examNorthPanel.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		examNorthPanel.setLayout(gbl_examNorthPanel);

		JLabel examLabel = new JLabel("Deine Pr\u00FCfungen");
		examLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_examLabel = new GridBagConstraints();
		gbc_examLabel.fill = GridBagConstraints.BOTH;
		gbc_examLabel.insets = new Insets(0, 0, 5, 5);
		gbc_examLabel.gridx = 0;
		gbc_examLabel.gridy = 2;
		examNorthPanel.add(examLabel, gbc_examLabel);

		JButton examAddButton = new JButton("Prüfung hinzufügen");
		examAddButton.addActionListener(actionListener);
		GridBagConstraints gbc_examAddButton = new GridBagConstraints();
		gbc_examAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_examAddButton.insets = new Insets(0, 0, 5, 0);
		gbc_examAddButton.gridx = 2;
		gbc_examAddButton.gridy = 2;
		examNorthPanel.add(examAddButton, gbc_examAddButton);

		JPanel examCenterPanel = new JPanel();
		examCard.add(examCenterPanel, BorderLayout.CENTER);
		examCenterPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane examScrollPane = new JScrollPane();
		examCenterPanel.add(examScrollPane, BorderLayout.CENTER);

		examTable = new JTable();
		// Design Stuff
		examTable.setShowVerticalLines(false);
		examTable.setRowHeight(40);
		examTable.setShowHorizontalLines(false);
		examTable.setIntercellSpacing(new Dimension(30, 10));

		examScrollPane.setViewportView(examTable);

		JPanel examSouthPanel = new JPanel();
		examCard.add(examSouthPanel, BorderLayout.SOUTH);
		examSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		JButton examBackButton = new JButton("Zur\u00FCck");
		examSouthPanel.add(examBackButton);
		examBackButton.addActionListener(new BackButtonListener(cards, "subjectCard", this));

		createSemesterTableModel();

		setVisible(true);
	}

	public void createSemesterTableModel() {
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Name");
		columnNames.add("Schule");
		columnNames.add("Durchschnitt");
		columnNames.add("Fächer");

		Vector<Object> columnTypes = new Vector<Object>();
		columnTypes.add(String.class);
		columnTypes.add(String.class);
		columnTypes.add(Double.class);
		columnTypes.add(JButton.class);

		@SuppressWarnings("rawtypes")
		Vector<Vector> datas = new Vector<Vector>();

		if (user.getSemesters() != null) {
			for (Semester semester : user.getSemesters()) {
				Vector<Object> row = new Vector<Object>();
				row.add(semester.getName());
				row.add(semester.getSchool());
				row.add(new DecimalFormat("#.##").format(semester.getAvarageGrade()));
				row.add("->");

				datas.add(row);
			}
		}

		semesterTable.setModel(new CostumTableModel(columnNames, columnTypes, datas, new SemesterTableButtonListener(this)));
		semesterTable.setEnabled(false);
		if (user.getSemesters() != null) {
			TableCellRenderer buttonRenderer = new JTableButtonRenderer();
			semesterTable.getColumn("Fächer").setCellRenderer(buttonRenderer);
			semesterTable.addMouseListener(new JTableButtonMouseListener(semesterTable));
		}

		// Allignement Center
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		semesterTable.getColumnModel().getColumn(2).setCellRenderer(tableRenderer);
	}

	public void createSubjectTableModel(int iterator) {
		this.subjectIterator = iterator;
		this.selectedSemesterID = user.getSemesters().get(subjectIterator).getId();
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Fach");
		columnNames.add("Durchschnitt");
		columnNames.add("Prüfungen");

		Vector<Object> columnTypes = new Vector<Object>();
		columnTypes.add(String.class);
		columnTypes.add(Double.class);
		columnTypes.add(JButton.class);

		@SuppressWarnings("rawtypes")
		Vector<Vector> datas = new Vector<Vector>();

		if (user.getSemesters().get(iterator).getSubjects() != null) {
			for (Subject subject : user.getSemesters().get(iterator).getSubjects()) {
				Vector<Object> row = new Vector<Object>();
				row.add(subject.getName());
				row.add(new DecimalFormat("#.##").format(subject.getAvarageGrade()));
				row.add("->");

				datas.add(row);
			}
		}

		subjectTable.setModel(new CostumTableModel(columnNames, columnTypes, datas, new SubjectTableButtonListener(this)));
		subjectTable.setEnabled(false);
		if (user.getSemesters().get(iterator).getSubjects() != null) {
			TableCellRenderer buttonRenderer = new JTableButtonRenderer();
			subjectTable.getColumn("Prüfungen").setCellRenderer(buttonRenderer);
			subjectTable.addMouseListener(new JTableButtonMouseListener(subjectTable));
		}

		// Allignement Center
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		subjectTable.getColumnModel().getColumn(1).setCellRenderer(tableRenderer);
	}

	public void createExamTableModel(int iterator) {
		this.examIterator = iterator;
		this.selectedSubjectID = user.getSemesters().get(subjectIterator).getSubjects().get(iterator).getId();
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Name");
		columnNames.add("Datum");
		columnNames.add("Note");
		columnNames.add("Zählt");

		Vector<Object> columnTypes = new Vector<Object>();
		columnTypes.add(String.class);
		columnTypes.add(String.class);
		columnTypes.add(Double.class);
		columnTypes.add(JComboBox.class);

		@SuppressWarnings("rawtypes")
		Vector<Vector> datas = new Vector<Vector>();
		ArrayList<Exam> exams = user.getSemesters().get(subjectIterator).getSubjects().get(iterator).getExams();
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		if (exams != null) {
			for (Exam exam : exams) {
				Vector<Object> row = new Vector<Object>();
				row.add(exam.getName());
				if (exam.getDate() == null) {
					row.add("Kein Datum");
				} else {
					row.add(df.format(exam.getDate()));
				}
				row.add(exam.getGrade());
				row.add(exam.isCount());

				datas.add(row);
			}
		}

		examTable.setModel(new CostumTableModel(columnNames, columnTypes, datas, new ExamTableButtonListener(this, exams)));
		examTable.setEnabled(false);

		if (exams != null) {
			TableCellRenderer checkBoxRenderer = new JTableCheckBoxRenderer();
			examTable.getColumn("Zählt").setCellRenderer(checkBoxRenderer);
			examTable.addMouseListener(new JTableButtonMouseListener(examTable));
		}

		// Allignement Center
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		examTable.getColumnModel().getColumn(2).setCellRenderer(tableRenderer);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JTable getSubjectTable() {
		return subjectTable;
	}

	public void setSubjectTable(JTable subjectTable) {
		this.subjectTable = subjectTable;
	}

	public JPanel getCards() {
		return cards;
	}

	public void setCards(JPanel cards) {
		this.cards = cards;
	}

	public int getSelectedSemesterID() {
		return selectedSemesterID;
	}

	public void setSelectedSemesterID(int selectedSemesterID) {
		this.selectedSemesterID = selectedSemesterID;
	}

	public int getSelectedSubjectID() {
		return selectedSubjectID;
	}

	public void setSelectedSubjectID(int selectedSubjectID) {
		this.selectedSubjectID = selectedSubjectID;
	}

	public int getSubjectIterator() {
		return subjectIterator;
	}

	public void setSubjectIterator(int subjectIterator) {
		this.subjectIterator = subjectIterator;
	}

	public int getExamIterator() {
		return examIterator;
	}

	public void setExamIterator(int examIterator) {
		this.examIterator = examIterator;
	}

}
