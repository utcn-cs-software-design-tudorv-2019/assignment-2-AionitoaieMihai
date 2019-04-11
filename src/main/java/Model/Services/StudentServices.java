package Model.Services;

import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Curs;
import Model.Entities.Student;
import Model.Entities.StudentProfile;
import Model.Entities.StudentProfile_has_Curs;
import Model.Repositories.StudentProfileCRUD;
import Model.Repositories.StudentProfileCursCRUD;

public class StudentServices {
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;
    
    StudentProfileCRUD spCRUD = new StudentProfileCRUD();
    StudentProfileCursCRUD spchCRUD = new StudentProfileCursCRUD();
	
	public void enrollStudent(Student student, Curs curs)
	{
		//studentprofile si curs
		StudentProfile temp = getStudentProfile(student);
		
		StudentProfile_has_Curs sphc = new StudentProfile_has_Curs(temp, curs);
		
		spchCRUD.create(sphc);
		
	}
	
	public int checkExists(String user, String pass)
	{
		session = sessionFactory.openSession();
		
		Query q = session.createQuery("select studentId from Student where userName = ? AND password = ?");
		//nu se poate pentru ca sunt 2 parametri
		
		q.setParameter(0, user);
		q.setParameter(1, pass);
		
		if((Integer) q.list().get(0) != 0)
		{
			//System.out.println("checkExists = " + (Integer)q.list().get(0));
			return (Integer) q.list().get(0);
			
		}
		

		session.close();
		
		
		
		return -1;
	}
	
	public void createStudentProfile(Student s)
	{
		Random r = new Random();
		StudentProfile sp = new StudentProfile(r.nextInt(5) + 1,s);
		
		spCRUD.create(sp);
		
	}
	
	public int getStudentProfileId(Student student)
	{
		//System.out.println("getStudentProfileId = " + student.getStudentId());
		
		StudentProfile spTemp = spCRUD.read(student.getStudentId());
		//return 0;
		
		System.out.println("getStudentProfileId = " + spTemp.getIdStudProfile());
		return spTemp.getIdStudProfile();
	}
	
	public StudentProfile getStudentProfile(Student s)
	{
		return spCRUD.read(s.getStudentId());
	}

}
