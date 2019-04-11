package Model.Repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Curs;
import Model.Entities.StudentProfile;
import Model.Entities.StudentProfile_has_Curs;

public class StudentProfileCursCRUD implements MasterInterface<StudentProfile_has_Curs, Integer>{

	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;
    
    
	public void create(StudentProfile_has_Curs obiect) {

		System.out.println("Creating new StudentProfileCurs record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public StudentProfile_has_Curs read(Integer idObiect) {
		
		StudentProfile_has_Curs spc;
		
		System.out.println("Reading stud profile has course record...");
		session = sessionFactory.openSession();
		
		//Query q = session.createQuery("select _spc from StudentProfile_has_Curs _sp WHERE idSPHC = :id ");
		//q.setParameter("id", (int)idObiect);
		
		//List<StudentProfile_has_Curs> spcs = q.list();
		
		//spc = spcs.get(0);
		

		spc = (StudentProfile_has_Curs) session.get(StudentProfile_has_Curs.class, idObiect);
		
		session.close();
		
		return spc;
	}

	public void update(StudentProfile_has_Curs obiect) {
		
		//System.out.println("Updating student profile has course...");
		//session = sessionFactory.openSession();
		
		//StudentProfile_has_Curs spc = (StudentProfile_has_Curs) session.get(StudentProfile_has_Curs.class, obiect.getIdSPHC());
	
		//ar trebui modifcate notele dar cine o face?
		
		//session.beginTransaction();
		//session.saveOrUpdate(sp);
		//session.getTransaction().commit();
		
		//session.close();
		
	}

	public void delete(Integer idObiect) {

		System.out.println("Deleting student profile has curs record...");
		session = sessionFactory.openSession();
		
		StudentProfile_has_Curs spc = (StudentProfile_has_Curs) session.get(StudentProfile_has_Curs.class, (int)idObiect);
		
		session.beginTransaction();
        session.delete(spc);
        session.getTransaction().commit();
		
		session.close();
		
	}

}
