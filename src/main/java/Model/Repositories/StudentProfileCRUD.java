package Model.Repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Curs;
import Model.Entities.StudentProfile;

public class StudentProfileCRUD implements MasterInterface<StudentProfile, Integer>{

	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;
    
	public void create(StudentProfile obiect) {
		
		System.out.println("Creating new StudentProfile record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public StudentProfile read(Integer idObiect) {//get StudentProfile by studentId
		
		StudentProfile sp = new StudentProfile();
		
		System.out.println("Reading stud profile record...");
		session = sessionFactory.openSession();
		
		//Query q = session.createQuery("select _sp from StudentProfile _sp WHERE studentId = ? ");
		//q.setParameter(0, idObiect);
		
		//List<StudentProfile> sps = q.list();

		//if(sps.size() != 0)
			//sp.setIdStudProfile(sps.get(0).getIdStudProfile());

		if(((StudentProfile)session.get(StudentProfile.class, idObiect)) != null)
			sp = (StudentProfile) session.get(StudentProfile.class, idObiect);
		
		
		session.close();
		
		return sp;
	}

	public void update(StudentProfile obiect) {
		
		System.out.println("Updating student profile...");
		session = sessionFactory.openSession();
		
		StudentProfile sp = (StudentProfile) session.get(StudentProfile.class, obiect.getIdStudProfile());
		
		sp.setGrupa(obiect.getGrupa());
		sp.setStudent(obiect.getStudent());

		session.beginTransaction();
		session.saveOrUpdate(sp);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public void delete(Integer idObiect) {
		
		System.out.println("Deleting student profile record...");
		session = sessionFactory.openSession();
		
		StudentProfile sp = (StudentProfile) session.get(StudentProfile.class, (int)idObiect);
		
		session.beginTransaction();
        session.delete(sp);
        session.getTransaction().commit();
		
		session.close();
		
	}




}
