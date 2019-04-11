package Controller;

import java.util.ArrayList;

import Model.Entities.Student;
import Model.Repositories.CursCRUD;
import Model.Services.CourseServices;


public class CursValidation {
	
	//CursDAO cd = new CursDAO();
	CursCRUD cursCRUD = new CursCRUD();
	CourseServices courseServices = new CourseServices();
	
	ArrayList<String> cursuri = new ArrayList<String>();
	
	public ArrayList<String> getCursuri()
	{
		return courseServices.getCursuri();
	}
	
	/*public ArrayList<String> getCursuriFromStudent(int idS)
	{
		return courseServices.getCursuriFromStudent(idS);
	}*/
	
	public ArrayList<String> getNote()
	{
		return courseServices.getGrades();
	}
	
	public int getCursId(String name)
	{
		return courseServices.getCourseId(name);
	}
	
	public ArrayList<String> getOreCursuri()
	{
		return courseServices.getHoursCourses();
	}

	
	public ArrayList<String> getCoursesFromStudent(Student student) {
		
		return courseServices.getCoursesFromStudent(student);
	}

}
