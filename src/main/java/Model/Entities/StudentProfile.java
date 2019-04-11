package Model.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class StudentProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudProfile;
	private int grupa;
	
	public StudentProfile()
	{
		this.idStudProfile = -1;
	}
	
	public StudentProfile(int grupa, Student student) {
		super();
		this.grupa = grupa;
		this.student = student;
	}

	public int getIdStudProfile() {
		return idStudProfile;
	}

	public void setIdStudProfile(int idStudProfile) {
		this.idStudProfile = idStudProfile;
	}

	public int getGrupa() {
		return grupa;
	}

	public void setGrupa(int grupa) {
		this.grupa = grupa;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@OneToOne
	@JoinColumn(name = "studentId")
	private Student student;
	
	//@OneToMany
	//private List<StudentProfile_has_Curs> sphc;

	@Override
	public String toString() {
		return "StudentProfile [idStudProfile=" + idStudProfile + ", grupa=" + grupa + "]";
	}

}
