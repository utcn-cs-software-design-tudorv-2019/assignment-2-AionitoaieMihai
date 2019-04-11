package Model.Repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Curs;
import Model.Entities.Student;

public class CursCRUD implements MasterInterface<Curs,Integer> {
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;
	
	public void create(Curs obiect)
	{
		System.out.println("Creating new curs record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public Curs read(Integer idObiect)
	{
		Curs c;
		
		System.out.println("Reading curs record...");
		session = sessionFactory.openSession();
		
		//Query q = session.createQuery("select _curs from Curs _curs WHERE idCurs = :id ");
		//q.setParameter("id", (int)idObiect);
		
		//List<Curs> courses = q.list();
		
		//c = courses.get(0);
		
		c = (Curs) session.get(Curs.class, idObiect);
		
		session.close();
		
		return c;
	}
	
	public void update(Curs obiect)
	{
		System.out.println("Updating course...");
		session = sessionFactory.openSession();
		
		Curs c = (Curs) session.get(Curs.class, obiect.getIdCurs());
		
		c.setEndTime(obiect.getEndTime());
		c.setNume(obiect.getNume());
		c.setSemester(obiect.getSemester());
		c.setStartTime(obiect.getStartTime());
		c.setYear(obiect.getYear());

		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void delete(Integer idObiect)
	{
		System.out.println("Deleting curs record...");
		session = sessionFactory.openSession();
		
		Curs c = (Curs) session.get(Curs.class, (int)idObiect);
		
		session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
		
		session.close();
	}

	

}
