package Controller;

import Model.Entities.Curs;
import Model.Entities.Student;
import Model.Repositories.StudentCRUD;
import Model.Services.StudentServices;

public class StudentAccesValidation {
	
	//StudentDAOImpl studentData = new StudentDAOImpl();
	StudentServices studentServices = new StudentServices();
	StudentCRUD studentCRUD = new StudentCRUD();
	
	public int grantAcces(String user, String password)
	{
		return studentServices.checkExists(user, password);
	}
	
	public Student getStudent(int id)
	{
		return studentCRUD.read(id);
	}
	
	public void editStudent(Student s)
	{
		studentCRUD.update(s);
	}
	
	public void registerStudent(Student s)
	{
		studentCRUD.create(s);
	}
	
	public void deleteStudent(int idS)
	{
		studentCRUD.delete(idS);
	}
	
	public void enrollStudent(Student student, Curs curs)
	{
		studentServices.enrollStudent(student, curs);
	}

	
	public void createStudentProfile(Student s)
	{
		studentServices.createStudentProfile(s);
	}

	public int getStudentProfileId(Student student) {
		
		return studentServices.getStudentProfileId(student);
		
	}
	
}
