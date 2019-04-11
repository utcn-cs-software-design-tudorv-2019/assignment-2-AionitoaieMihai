package Presentation.EnrollUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CursValidation;
import Controller.StudentAccesValidation;
import Model.Entities.Curs;
import Model.Entities.Student;
import Presentation.StudentUI.StudentInfo;

public class EnrollInfo extends JFrame {

	private JPanel contentPane;
	JComboBox comboCursuri;
	CursValidation cv = new CursValidation();
	StudentAccesValidation av = new StudentAccesValidation();
	Student student = new Student();
	Curs curs = new Curs();
	
	ArrayList<String> cursuri = new ArrayList<String>();
	int idS;
	
	public void populateEnrollInfo(Student student)
	{
		cursuri = cv.getCursuri();	
		
		this.student = student;
		this.idS = student.getStudentId();
		
		for(int i = 0; i < cursuri.size(); i++)
		{
			comboCursuri.addItem(cursuri.get(i));
		}
	}
	
	public EnrollInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboCursuri = new JComboBox();
		comboCursuri.setBounds(98, 11, 110, 22);
		contentPane.add(comboCursuri);
		
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.setBounds(111, 147, 89, 23);
		contentPane.add(btnEnroll);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 147, 74, 23);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				StudentInfo frame = new StudentInfo(false,idS);
				frame.populateFields(idS);
				frame.setVisible(true);
			}
		});
		
		
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(comboCursuri.getSelectedItem().toString());
				
				curs.setIdCurs(cv.getCursId(comboCursuri.getSelectedItem().toString()));
				av.enrollStudent(student, curs);
				//av.enrollStudent(idS, cv.getCursId(comboCursuri.getSelectedItem().toString()));

				
				setVisible(false);
				StudentInfo frame = new StudentInfo(false,idS);
				frame.populateFields(idS);
				frame.setVisible(true);
			}
		});
	}
}
