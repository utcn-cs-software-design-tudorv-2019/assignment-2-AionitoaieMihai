package Model.Entities;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentProfile_has_Curs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSPHC;
	
	@ManyToOne
	@JoinColumn(name = "idCurs")
	private Curs curs;
	
	@ManyToOne
	@JoinColumn(name = "idStudProfile")
	private StudentProfile studentProfile;
	
	private int notaPartial;
	private int notaColocviu;
	private int notaExamen;

	
	
	public StudentProfile_has_Curs(StudentProfile studentProfile, Curs curs) {
		this.curs = curs;
		this.studentProfile = studentProfile;
		
		Random random = new Random();
		this.setNotaPartial(random.nextInt(9 - 5 + 1) + 5);
		this.setNotaColocviu(random.nextInt(9 - 5 + 1) + 5);
		this.setNotaExamen(random.nextInt(9 - 5 + 1) + 5);
	}
	
	public StudentProfile_has_Curs() {

	}

	public int getIdSPHC() {
		return idSPHC;
	}

	public void setIdSPHC(int idSPHC) {
		this.idSPHC = idSPHC;
	}

	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}

	public StudentProfile getStudentProfile() {
		return studentProfile;
	}

	public void setStudentProfile(StudentProfile studentProfile) {
		this.studentProfile = studentProfile;
	}

	public int getNotaPartial() {
		return notaPartial;
	}

	public void setNotaPartial(int notaPartial) {
		this.notaPartial = notaPartial;
	}

	public int getNotaColocviu() {
		return notaColocviu;
	}

	public void setNotaColocviu(int notaColocviu) {
		this.notaColocviu = notaColocviu;
	}

	public int getNotaExamen() {
		return notaExamen;
	}

	public void setNotaExamen(int notaExamen) {
		this.notaExamen = notaExamen;
	}

}
