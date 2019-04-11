package ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import Model.Entities.Curs;
import Model.Entities.Student;
import Model.Entities.StudentProfile;
import Model.Entities.StudentProfile_has_Curs;
import Model.Repositories.CursCRUD;
import Model.Repositories.StudentCRUD;
import Model.Repositories.StudentProfileCRUD;
import Model.Repositories.StudentProfileCursCRUD;
 
public class RunnerProiect {
	
	StudentCRUD studCRUD = new StudentCRUD();
	CursCRUD cursCRUD = new CursCRUD();
	StudentProfileCRUD spCRUD = new StudentProfileCRUD();
	StudentProfileCursCRUD spcCRUD = new StudentProfileCursCRUD();
	
	Random random = new Random();
	
	/*select * from student
	inner join StudentProfile ON student.idstudent = StudentProfile.student_idstudent
	inner join StudentProfile_has_Curs ON StudentProfile.idStudentProfile = StudentProfile_has_Curs.idStudentProfile
	inner join Curs ON StudentProfile_has_Curs.idCurs = Curs.idCurs; #where idstudent = 2;*/
     
    @Test
    public void crud() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
         
        //createStudent();
        
        //createCourse();
        
        //createSP(session);
        
        //createSPC(session);
        
        ///////////////////////////////////////////////////////////
        
        //create(session);
        //read(session);
         
        //update(session);
        //read(session);
         
        //delete(session);
        //read(session);
         
        session.close();
    }
    
    private void createStudent()
    {
    	//Student s1 = new Student("ion","123","adr1","qwe","qwe");
    	//Student s2 = new Student("ion2","1232","adr12","qwer","qwer");
    	
    	Student s1 = new Student("andrei","123","adr1","qwe","qwe");
    	Student s2 = new Student("ana","124","adr2","asd","asd");
    	Student s3 = new Student("ion","125","adr3","zxc","zxc");
    	Student s4 = new Student("vasile","126","adr4","qaz","qaz");
    
    	//create
    	
    	studCRUD.create(s1);
    	studCRUD.create(s2);
    	studCRUD.create(s3);
    	studCRUD.create(s4);
    	
    	Student t1;
    	Student t2;
    	
    	//read
    	
    	t1 = studCRUD.read(s1.getStudentId());
    	t2 = studCRUD.read(s2.getStudentId());
    	
    	System.out.println(t1);
    	System.out.println(t2);
    	
    	//update
    	
    	//s2.setNume("ion4");
    	//studCRUD.update(s2);
    	
    	//read
    	
    	//t2 = studCRUD.read(s2.getStudentId());
    	//System.out.println(t2);
    	
    	//delete
    	
    	//studCRUD.delete(s1.getStudentId());
    	

    	
    	
    	
    }
    
    private void createCourse()
    {
    	//Curs c1 = new Curs("Biology",8,10,1,1);
    	//Curs c2 = new Curs("English",10,11,1,2);
    	
    	Curs c1 = new Curs("Eco",8,10,1,1);
    	Curs c2 = new Curs("Math",10,12,1,2);
    	Curs c3 = new Curs("English",14,16,2,1);
    	Curs c4 = new Curs("Med",12,14,2,2);
    
    	//create
    	
    	cursCRUD.create(c1);
    	cursCRUD.create(c2);
    	cursCRUD.create(c3);
    	cursCRUD.create(c4);
    	
    	Curs t1;
    	Curs t2;
    	
    	//read
    	
    	t1 = cursCRUD.read(c1.getIdCurs());
    	t2 = cursCRUD.read(c2.getIdCurs());
    	
    	System.out.println(t1);
    	System.out.println(t2);
    	
    	//update
    	
    	//c2.setNume("Phys");
    	//cursCRUD.update(c2);
    	
    	//read
    	
    	//t2 = cursCRUD.read(c2.getIdCurs());
    	//System.out.println(t2);
    	
    	//delete
    	
    	//cursCRUD.delete(c1.getIdCurs());
    }
    
    private void createSP(Session session)
    {
    	//get Students
    	Query q2 = session.createQuery("select _student from Student _student");
    	List<Student> students = q2.list();
    	
    	List<StudentProfile> sp = new ArrayList<StudentProfile>();
    	
    	StudentProfile temp;
    	for(Student s : students)
    	{
    		temp = new StudentProfile((random.nextInt(5) + 1), s);
    		//s.setStudentProfile(temp);
    		sp.add(temp);
    	}
    
    	//create
    	
    	for(StudentProfile s : sp)
    	{
    		spCRUD.create(s);
    	}

    	//read
    	//t1 = cursCRUD.read(c1.getIdCurs());
    	//t2 = cursCRUD.read(c2.getIdCurs());
    	//System.out.println(t1);
    	//System.out.println(t2);
    	
    	//update
    	sp.get(2).setGrupa(10);
    	spCRUD.update(sp.get(2));
    	
    	//read
    	//t2 = cursCRUD.read(c2.getIdCurs());
    	//System.out.println(t2);
    	
    	//delete
    	
    	//cursCRUD.delete(c1.getIdCurs());
    }
    
    private void createSPC(Session session)
    {
    	//get Students
    	Query q2 = session.createQuery("select _student from Student _student");
    	List<Student> students = q2.list();
    	
    	//get Courses
    	Query q1 = session.createQuery("select _curs from Curs _curs");
    	List<Curs> courses = q1.list();
    	
    	//get s profiles
    	Query q0 = session.createQuery("select _sp from StudentProfile _sp");
    	List<StudentProfile> sps = q0.list();
    	
    	List<StudentProfile_has_Curs> sphcs = new ArrayList<StudentProfile_has_Curs>();
    	
    	StudentProfile_has_Curs temp;
    	
    	for(StudentProfile sp : sps)
    	{
    		temp = new StudentProfile_has_Curs(sp, courses.get(random.nextInt(courses.size())));
    		sphcs.add(temp);
    	}
    	
    	for(StudentProfile_has_Curs sphc : sphcs)
    	{
    		spcCRUD.create(sphc);
    	}
    	
    }
    
    //////////////////////////////////
    
    //todo delete update 
     
    private void delete(Session session) {
        System.out.println("Deleting mondeo record...");
        Car mondeo = (Car) session.get(Car.class, "mondeo");
         
        session.beginTransaction();
        session.delete(mondeo);
        session.getTransaction().commit();
    }
     
    private void update(Session session) {
        System.out.println("Updating mustang price...");
        Car mustang = (Car) session.get(Car.class, "mustang");
        mustang.setModel("mustang");
        mustang.setPrice("£35,250.00");
         
        session.beginTransaction();
        session.saveOrUpdate(mustang);
        session.getTransaction().commit();
    }
 
    private void create(Session session) {
        System.out.println("Creating student records...");

        Student s1 = new Student();
        s1.setNume("Andrei");
        s1.setCnp("123");
        
        Student s2 = new Student();
        s2.setNume("Ana");
        s2.setCnp("124");
        
        System.out.println("Creating curs records...");
        
        Curs c1 = new Curs();
        c1.setNume("Eco");
        c1.setYear(2);
       
        Curs c2 = new Curs();
        c2.setNume("Math");
        c2.setYear(1);
        
        session.beginTransaction();
        session.save(s1);
        session.save(s2);
        session.save(c1);
        session.save(c2);
        session.getTransaction().commit();
    }
     
    private void read(Session session) {
        Query q = session.createQuery("select studentId from Student");
        Query q1 = session.createQuery("select _curs from Curs _curs");
        Query q2 = session.createQuery("select _student from Student _student");
        
        List ids = q.list();
        List<Curs> cursuri = q1.list();
        List<Student> students = q2.list();
        
        System.out.println("Creating student_profile records...");
        
        StudentProfile sp1 = new StudentProfile();
        sp1.setGrupa(3);
        sp1.setStudent(students.get(0));
        //sp1.setFk_student_ids((Integer) ids.get(0));
        
        StudentProfile sp2 = new StudentProfile();
        sp2.setGrupa(4);
        sp2.setStudent(students.get(1));
        //sp2.setFk_student_ids((Integer) ids.get(1));
        
        
        System.out.println("Creating studentProfile_has_Curs records...");
        
        //StudentProfile_has_Curs sphc1 = new StudentProfile_has_Curs(cursuri.get(1),sp1);
        //StudentProfile_has_Curs sphc2 = new StudentProfile_has_Curs(cursuri.get(0),sp2);

        session.beginTransaction();
        
        session.save(sp1);
        session.save(sp2);
       // session.save(sphc1);
       // session.save(sphc2);
        
        session.getTransaction().commit();
      
    }
}