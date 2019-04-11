package Model.Repositories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

import Model.Entities.Student;

public class StudentCRUD implements MasterInterface<Student,Integer> {
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;
	
	public void create(Student obiect)
	{
		System.out.println("Creating new student record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public Student read(Integer idObiect)
	{
		Student s;
		
		System.out.println("Reading student record...");
		session = sessionFactory.openSession();
		
		//Query q = session.createQuery("select _student from Student _student WHERE studentId = :id ");
		//q.setParameter("id", (int)idObiect);
		
		//List<Student> students = q.list();
		
		//s = students.get(0);
		
		s = (Student)session.get(Student.class, idObiect);
		
		session.close();
		
		return s;
	}
	
	public void update(Student obiect)
	{
		System.out.println("Updating student...");
		session = sessionFactory.openSession();
		
		Student s = (Student) session.get(Student.class, obiect.getStudentId());
		
		s.setAdresa(obiect.getAdresa());
		s.setCnp(obiect.getCnp());
		s.setNume(obiect.getNume());

		session.beginTransaction();
		session.saveOrUpdate(s);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void delete(Integer idObiect)
	{
		System.out.println("Deleting student record...");
		session = sessionFactory.openSession();
		
		Student s = (Student) session.get(Student.class, (int)idObiect);
		
		session.beginTransaction();
        session.delete(s);
        session.getTransaction().commit();
		
		session.close();
	}

	

}
