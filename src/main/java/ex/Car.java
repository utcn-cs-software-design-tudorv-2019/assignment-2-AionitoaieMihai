package ex;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //nume tabela
public class Car {
	
	private static final long serialVersionUID = 1L;
	
	@Id //primary key
	private String model;
	private String price;
	
	//private Obiect obj;
	//void setObiect (Obiect o) { this.obj = o; } <= DI (Dependency Injection)
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
