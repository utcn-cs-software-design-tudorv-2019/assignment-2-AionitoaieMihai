package Model.Services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import Model.Entities.Curs;
import Model.Entities.Student;
import Model.Entities.StudentProfile;
import Model.Entities.StudentProfile_has_Curs;
import Model.Repositories.StudentProfileCursCRUD;

public class CourseServices {
	
	StudentServices ss = new StudentServices();
	
	ArrayList<String> cursuri = new ArrayList<String>();
	ArrayList<String> note = new ArrayList<String>();
	ArrayList<String> ore = new ArrayList<String>();
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;
    
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getCursuri()
	{
		session = sessionFactory.openSession();
		//session = sessionFactory.getCurrentSession();
		
		//Query q =  session.createQuery("select nume from Curs");
		
		//cursuri = (ArrayList<String>) q.list();
		
		//System.out.println("cursuri size " + cursuri.size());
		
		cursuri.removeAll(cursuri);
		
		List<Curs> cs = session.createCriteria(Curs.class).list();
		
		for(int i = 0; i < cs.size(); i++)
		{
			cursuri.add(cs.get(i).getNume());
		}
			
		session.close();

		return cursuri;
	}

	public ArrayList<String> getCoursesFromStudent(Student s)
	{
		session = sessionFactory.openSession();
		
		cursuri.removeAll(cursuri);
		note.removeAll(note);
		ore.removeAll(ore);
		
		//get studentprofile id
		//get student has curs id
		//get curs fk id
		//get curs
		
		StudentProfile spTemp = ss.getStudentProfile(s);
		
		int spId = spTemp.getIdStudProfile();
		///////////////////
		
		Criteria criteria = session.createCriteria(StudentProfile_has_Curs.class);
		criteria.add(Restrictions.eq("studentProfile", spTemp));
		
		
		List<StudentProfile_has_Curs> sphcTemp = criteria.list();
		
		for(int i = 0; i < sphcTemp.size(); i++)
		{
			//pentru fiecare student profile has curs iau fiecare curs
			StudentProfile_has_Curs temp = sphcTemp.get(i);
			Curs c;
			
			note.add("" + temp.getNotaPartial());
			note.add("" + temp.getNotaColocviu());
			note.add("" + temp.getNotaExamen());
			
			Criteria cr = session.createCriteria(Curs.class);
			cr.add(Restrictions.eq("idCurs", temp.getCurs().getIdCurs()));
			
			c = (Curs)cr.uniqueResult();
			cursuri.add(c.getNume());
			ore.add(c.getStartTime() + "");
			ore.add(c.getEndTime() + "");
			ore.add(c.getSemester() + "");
			ore.add(c.getYear() + "");
		}
		
		//StudentProfile_has_Curs sphcTemp = new StudentProfileCursCRUD().read(spTemp.getIdStudProfile());
		
		//int sphcId = sphcTemp.getIdSPHC();
		
		//Criteria criteria = session.createCriteria(Curs.class);
		//criteria.add(Restrictions.eq("idCurs", sphcTemp.getCurs().getIdCurs()));
		
		//c = (Curs)criteria.uniqueResult();
		
		/*Query q1 = session.createSQLQuery("select Curs.nume, startTime, endTime, year, semester from student \r\n" + 
				"inner join StudentProfile ON student.studentId = StudentProfile.idstudprofile\r\n" + 
				"inner join StudentProfile_has_Curs ON StudentProfile.idstudprofile = StudentProfile_has_Curs.idstudprofile\r\n" + 
				"inner join Curs ON StudentProfile_has_Curs.idCurs = Curs.idCurs where Student.studentId = ?");
		
		q1.setParameter(0, s.getStudentId());
		
		List<Object[]> courses = q1.list();
		
		for(Object[] o : courses)
		{
			cursuri.add("" + o[0]);
			ore.add("" + o[1]);
			ore.add("" + o[2]);
			ore.add("" + o[3]);
			ore.add("" + o[4]);
		}
		
		System.out.println("Course Services added in cursuri and ore");
		
		Query q2 = session.createSQLQuery("select notaPartial, notaColocviu, notaExamen from student \r\n" + 
				"inner join StudentProfile ON student.studentId = StudentProfile.idstudprofile\r\n" + 
				"inner join StudentProfile_has_Curs ON StudentProfile.idstudprofile = StudentProfile_has_Curs.idstudprofile\r\n" + 
				"inner join Curs ON StudentProfile_has_Curs.idCurs = Curs.idCurs where Student.studentId = ?");
		
		q2.setParameter(0, s.getStudentId());
		
		List<Object[]> sphc = q2.list();
		
		for(Object[] o : sphc)
		{
			note.add("" + o[0]);
			note.add("" + o[1]);
			note.add("" + o[2]);
		}

		
		session.close();*/
		session.close();
		
		return cursuri;
		
	}
	
	public ArrayList<String> getHoursCourses()
	{
		return ore;
	}
	
	public int getCourseId(String name)
	{
		session = sessionFactory.openSession();
		
		//Query q =  session.createQuery("select idCurs from Curs where nume = ?");
		
		//q.setParameter(0, name);
		
		//List<Integer> a = q.list();
		
		Curs c;
		
		Criteria criteria = session.createCriteria(Curs.class);
		criteria.add(Restrictions.eq("nume", name));
		
		c = (Curs)criteria.uniqueResult();
		
		session.close();
		
		//return a.get(0);.
		return c.getIdCurs();
	}
	
	public ArrayList<String> getGrades()
	{
		return note;
	}
	
	protected void finalize() throws Throwable  
	{  
	    try { session.close(); } 
	    catch (HibernateException e) { 
	        e.printStackTrace();
	    }
	    super.finalize();  
	} 
}
