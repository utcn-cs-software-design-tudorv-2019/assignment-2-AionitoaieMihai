package Model.Repositories;

import Model.Entities.Student;

public interface MasterInterface <T,U> {

	public void create(T obiect);
	public  T read(U idObiect);
	public  void update(T obiect);
	public  void delete(U idObiect);
	
}
