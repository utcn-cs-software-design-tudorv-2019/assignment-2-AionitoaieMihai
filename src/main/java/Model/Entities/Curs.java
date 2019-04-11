package Model.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Curs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurs;
	private String nume;
	private int startTime;
	private int endTime;
	private int year;
	private int semester;
	
	//@OneToMany
	//private List<StudentProfile_has_Curs> sphc;
	
	public Curs() {}
	
	public Curs(String nume, int startTime,int endTime,int year,int semester)
	{
		this.nume = nume;
		this.startTime = startTime;
		this.endTime = endTime;
		this.year = year;
		this.semester = semester;
	}
	
	public int getIdCurs() {
		return idCurs;
	}
	public void setIdCurs(int idCurs) {
		this.idCurs = idCurs;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

}
